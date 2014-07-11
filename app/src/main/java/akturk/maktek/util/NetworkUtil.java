package akturk.maktek.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkUtil {

    public static boolean isOnline(Context context) {
        ConnectivityManager tempConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo tempNetworkInfo = tempConnectivityManager.getActiveNetworkInfo();

        if (tempNetworkInfo != null && tempNetworkInfo.isConnectedOrConnecting())
            return true;

        return false;
    }
}
