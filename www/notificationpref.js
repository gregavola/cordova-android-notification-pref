/* global cordova:false */
/* globals window */

var exec = cordova.require('cordova/exec'),
    utils = cordova.require('cordova/utils');

var NotificationPref = {
    openSettings: function(successCallback, errorCallback, options) {
        exec(
            successCallback,
            errorCallback,
            'NotificationPref',
            'openSettings',
            [options]
        );
    }
};

module.exports = NotificationPref;
