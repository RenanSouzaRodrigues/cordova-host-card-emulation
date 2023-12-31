package powerpush.cordova.plugins.hostcardemulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;

public class HostCardEmulationService extends HostApduService {

    private static final String TAG = "HostCardEmulationService";

    private static HCEPlugin hcePlugin;
    private static HostCardEmulationService hceService;

    public static void setupHcePlugin(HCEPlugin plugin) {
        hcePlugin = plugin;
    }

    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        hceService = this;
        if (hcePlugin != null) hcePlugin.send(commandApdu);
        return null;
    }

    public static boolean sendResponse(byte[] data) {
        if (hceService == null) return false;
        hceService.sendResponseApdu(data);
        return true;
    }

    @Override
    public void onDeactivated(int reason) {
        if (hcePlugin != null) hcePlugin.deactivated(reason);
    }

    public static String ByteArrayToHexString(byte[] bytes) {
        final char[] hexArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] hexChars = new char[bytes.length * 2]; // Each byte has two hex characters (nibbles)
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF; // Cast bytes[j] to int, treating as unsigned value
            hexChars[j * 2] = hexArray[v >>> 4]; // Select hex character from upper nibble
            hexChars[j * 2 + 1] = hexArray[v & 0x0F]; // Select hex character from lower nibble
        }
        return new String(hexChars);
    }

}