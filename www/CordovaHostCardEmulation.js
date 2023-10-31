var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'CordovaHostCardEmulation', 'coolMethod', [arg0]);
};


module.exports = {
    listenReaderDevice: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CordovaHostCardEmulation", "listenReaderDevice", []);
    },

    sendResponseToReaderDevice: function (response, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CordovaHostCardEmulation", "sendResponseToReaderDevice", [response]);
    },

    stopListeningReaderDevice: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CordovaHostCardEmulation", "stopListeningReaderDevice", []);
    }
}