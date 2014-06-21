package akturk.maktek.helper;

import android.content.Context;
import android.graphics.Typeface;

public class TypefaceLoader {
    private static Typeface mRobotoThinTypeface;
    private static Typeface mRobotoCondensedBoldTypeface;

    public static Typeface getRobotoThin(Context context) {
        if (mRobotoThinTypeface == null)
            mRobotoThinTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_thin.ttf");

        return mRobotoThinTypeface;
    }

    public static Typeface getRobotoCondensedBold(Context context) {
        if (mRobotoCondensedBoldTypeface == null)
            mRobotoCondensedBoldTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_condensed_bold.ttf");

        return mRobotoCondensedBoldTypeface;
    }
}
