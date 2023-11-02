declare module "cordova-host-card-emulation" {
    /**
     * Function to start listening for reader device
     * @param successCallback Success callback
     * @param errorCallback  Error callback
     */
    export function listenReaderDevice(successCallback: (data: any) => void, errorCallback: (err: any) => void): void;
    
    /**
     * Function to stop listening for reader device
     * @param successCallback Success callback
     * @param errorCallback Error callback
     */
    export function stopListeningReaderDevice(successCallback: (data: any) => void, errorCallback: (err: any) => void): void;
    
    /**
     * Function to send the response to the reader device. The response must be inside the listener event callback.
     * @param response The response to send to the reader device in Uint8Array format
     * @param successCallback 
     * @param errorCallback 
     */
    export function sendResponseToReaderDevice(response: Uint8Array, successCallback: (data: any) => void, errorCallback: (err: any) => void): void;
}