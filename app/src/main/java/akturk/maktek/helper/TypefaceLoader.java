package akturk.maktek.helper;

import android.content.Context;
import android.graphics.Typeface;

public class TypefaceLoader {
    private static Typeface mRobotoThinTypeface;

    public static Typeface getRobotoThin(Context context) {
        if (mRobotoThinTypeface == null)
            mRobotoThinTypeface = Typeface.createFromAsset(context.getAssets(),"font/roboto_thin.ttf");

        return mRobotoThinTypeface;
    }
}
