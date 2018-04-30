"use strict";

Function('return this')().Benchmark = {
  name: "<unknown>",
  benchmarkFun: null,

  userAgent: (function() {
    if (typeof process !== "undefined") {
      return "Node.js";
    } else if (typeof navigator !== "undefined") {
      var userAgent = navigator.userAgent
      if (userAgent.indexOf("Chrome") >= 0)
        return "Chrome";
      else if (userAgent.indexOf("Firefox") >= 0)
        return "Firefox";
      else
        return "Unknown";
    } else {
      return "Unknown";
    }
  })(),

  performanceTime: (function() {
    if (typeof performance !== "undefined" && performance.now) {
      return (function() {
        return performance.now();
      });
    } else if (typeof process !== "undefined") {
      return (function() {
        var pair = process.hrtime();
        return (pair[0] * 1000.0) + (pair[1] / 1000000.0);
      });
    } else {
      return (function() {
        return new Date().getTime();
      });
    }
  })(),

  main: function(name, benchmarkFun) {
    this.name = name;
    this.benchmarkFun = benchmarkFun;
    if (typeof window === "undefined")
      console.log(this.report());
  },

  mainHTML: function(name, benchmarkFun) {
    var self = this;

    this.name = name;
    this.benchmarkFun = benchmarkFun;

    document.title = this.name;

    var body = document.body;

    var title = document.createElement("h1");
    title.textContent = document.title;
    body.appendChild(title);

    var runButton = document.createElement("button");
    runButton.textContent = "Run benchmarks";
    body.appendChild(runButton);

    var statusText = document.createElement("p");
    body.appendChild(statusText);

    runButton.onclick = (function() {
      runButton.enabled = false;
      statusText.textContent = "Running ...";

      setTimeout(function() {
        var status;
        try {
          status = self.report();
        } catch (e) {
          status = e.toString();
        }
        statusText.textContent = status;
        runButton.enabled = true;
      }, 10);
    });
  },

  runBenchmark: function(timeMinimum, runsMinimum) {
    var runs = 0;
    var enoughTime = false;
    var stopTime = this.performanceTime() + timeMinimum;

    var samples = [];
    var benchmarkFun = this.benchmarkFun;

    do {
      var startTime = this.performanceTime();
      benchmarkFun();
      var endTime = this.performanceTime();
      samples.push((endTime - startTime) * 1000.0);
      runs += 1;
      enoughTime = endTime >= stopTime;
    } while (!enoughTime || runs < runsMinimum);

    return this.meanAndSEM(samples);
  },

  meanAndSEM: function(samples) {
    var n = samples.length;
    var sum = 0;
    for (var i = 0; i != n; i++)
      sum += samples[i];
    var mean = sum / n;
    var sem = this.standardErrorOfTheMean(samples, mean);
    return [mean, sem];
  },

  standardErrorOfTheMean: function(samples, mean) {
    var n = samples.length;
    var acc = 0;
    for (var i = 0; i != n; i++) {
      var diffToMean = samples[i] - mean;
      acc += diffToMean * diffToMean;
    }
    return Math.sqrt(acc / (n * (n - 1)));
  },

  warmUp: function() {
    this.runBenchmark(1000, 10);
  },

  report: function() {
    this.warmUp();
    var meanAndSEM = this.runBenchmark(3000, 20);
    var mean = meanAndSEM[0];
    var sem = meanAndSEM[1];

    return "js;" + this.name + ";" + this.userAgent + ";" + mean + ";" + sem;
  }
};
