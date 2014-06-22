package akturk.maktek.global;

import android.app.Application;

import akturk.maktek.helper.TypefaceLoader;

public final class MaktekApplication extends Application {
    public static TypefaceLoader mTypefaceLoader;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
