'use strict';

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