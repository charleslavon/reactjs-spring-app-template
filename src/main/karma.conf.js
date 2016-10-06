// Karma configuration
//
// For all available config options and default values, see:
// http://karma-runner.github.io/0.10/config/configuration-file.html

module.exports = function(config) {
    'use strict';

    config.set({

        // base path is '', it will be used to resolve files and exclude
        // we read all test files from 'webapp' to accomodate our build process, 
        //primarly templates.js
        basePath: '',

        // frameworks to use
        frameworks: ['jasmine'],


        // list of files / patterns to load in the browser
        files: [
            // loaded without require

            // hack to load RequireJS after the shim libs
            'node_modules/requirejs/require.js',
            'node_modules/karma-requirejs/lib/adapter.js',


            // loaded with require

            {
                pattern: '',
                included: false
            },    
            {
                pattern: '',
                included: false
            },
            {
                pattern: 'webapp/js/**/*.js',
                included: false
            }, 
            {
                pattern: 'test/spec/**/*.js',
                included: false
            },


            'test/test-main.js'
        ],

        // list of files to exclude
        exclude: [
            'webapp/js/main.js',
        ],

        // test results reporter to use
        // possible values: 'dots', 'progress', 'junit', 'growl', 'coverage','threshold'

        reporters: ['progress', 'coverage'],

        preprocessors: {
            // source files, that you want to  generate coverage for 
            // do not include tests or libraries 
            // (these files will be instrumented by Istanbul) 
            '**app/js/**/*.js': ['coverage']
        },

        coverageReporter: {
            dir: 'coverage/',
            reporters: [{
                type: 'cobertura',
                subdir: 'cobertura-coverage/',
                file: 'cobertura.xml'
            }, {
                type: 'text'
            }],
        },

                // set the threshold here 
                thresholdReporter: {
                           functions: 80,
                           lines: 100
                   },


        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: true,
        logLevel: "LOG_DEBUG",

        // Start these browsers, currently available:
        // - Chrome
        // - ChromeCanary
        // - Firefox
        // - Opera
        // - Safari (only Mac)
        // - PhantomJS
        // - IE (only Windows)
        browsers: [
            'PhantomJS' //FYI change this to chrome to get a consistent test result when writing unit tests.They both give inconsistent results
        ],

        // If browser does not capture in given timeout [ms], kill it
        captureTimeout: 5000,

        // Continuous Integration mode
        // if true, it capture browsers, run tests and exit
        singleRun: false,

        // Karma will report all the tests that are slower than given time limit (in
        // ms).
        reportSlowerThan: 500
    });
};
