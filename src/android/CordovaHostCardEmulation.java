package powerpush.cordova.plugins.hostcardemulation;

import org.apache.cordova.CordovaPlugin;
import java.util.Arrays;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import powerpush.cordova.plugins.hostcardemulation.HostCardEmulationService;


public class CordovaHostCardEmulation extends CordovaPlugin {
    private static final String TAG = "CordovaHostCardEmulation";

    private CallbackContext commandCallback;
    private CallbackContext deactivatedCallback;

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
            case "listenReaderDevice":
                this.listenReaderDevice(callbackContext);
                return true;
                break;

            case "sendResponseToReaderDevice":
                this.sendResponseToReaderDevice(args.getArrayBuffer(0), callbackContext);
                return true;
                break;

            case "stopListeningReaderDevice":
                this.stopListeningReaderDevice(callbackContext);
                return true;
                break;
        
            default:
                return false;
                break;
        }
    }

    public void listenReaderDevice(CallbackContext context) {
        HostCardEmulationService.setupHcePlugin(this);
        this.commandCallback = context;
        PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT);
        result.setKeepCallback(true);
        this.callbackContext.sendPluginResult(result);
    } 

    public void sendResponseToReaderDevice(byte[] data, CallbackContext context) {
        if (HostCardEmulationService.sendResponse(data)) context.success();
        else context.error("Missing Reference to HostCardEmulationService.");
    }

    public void stopListeningReaderDevice(CallbackContext context) {
        this.deactivatedCallback = context;
        PluginResult result = new PluginResult(PluginResult.Status.NO_RESULT);
        result.setKeepCallback(true);
        callbackContext.sendPluginResult(result);
    }

    public void deactivated(int reason) {
        if (this.deactivatedCallback == null) return;
        PluginResult result = new PluginResult(PluginResult.Status.OK, reason);
        result.setKeepCallback(true);
        this.deactivatedCallback.sendPluginResult(result);
    }

    public void send(byte[] command) {
        if (this.commandCallback == null) return;
        PluginResult result = new PluginResult(PluginResult.Status.OK, command);
        result.setKeepCallback(true);
        this.commandCallback.sendPluginResult(result);
        
    }




















    public void sendCommand(byte[] command) {
        Log.d(TAG, "sendCommand " + Arrays.toString(command));
        if (commandCallback != null) {
            PluginResult result = new PluginResult(PluginResult.Status.OK, command);
            result.setKeepCallback(true);
            commandCallback.sendPluginResult(result);
        }
    }
}
