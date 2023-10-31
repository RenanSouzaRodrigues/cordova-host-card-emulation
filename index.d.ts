declare module "cordova-host-card-emulation" {
    export function listenReaderDevice(successCallback: function, errorCallback: function): void;
    export function sendResponse(response: string, successCallback: function, errorCallback: function): void;
    export function stopListeningReaderDevice(successCallback: function, errorCallback: function): void;
}