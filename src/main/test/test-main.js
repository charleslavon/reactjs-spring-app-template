'use strict';

var tests = Object.keys(window.__karma__.files).filter(function(file) {
    return (/\.spec\.js$/.test(file));
});

requirejs.config({
    // Karma serves files from '/base/webapp/'
    baseUrl: '/base/webapp/',

    paths: {
    	'flight': 'bower_components/flight',
        'component': 'js/component', 
       
    },

    // ask Require.js to load these files (all our tests)
    deps: tests,

    // start test run, once Require.js is done
    callback: function() {
        window.__karma__.start();
    }   
});
