'use strict';

var cordova = require('cordova');

exports.listenReaderDevice = function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "CordovaHostCardEmulation", "listenReaderDevice", []);
},

exports.sendResponseToReaderDevice = function (response, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "CordovaHostCardEmulation", "sendResponseToReaderDevice", [response]);
},

exports.stopListeningReaderDevice = function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "CordovaHostCardEmulation", "stopListeningReaderDevice", []);
}