package akturk.maktek.helper;

import android.content.Context;
import android.graphics.Typeface;

public final class TypefaceLoader {
    private static Typeface mRobotoThinTypeface;
    private static Typeface mRobotoLightTypeface;
    private static Typeface mRobotoRegularTypeface;
    private static Typeface mRobotoMediumTypeface;
    private static Typeface mRobotoCondensedLightTypeface;
    private static Typeface mRobotoCondensedRegularTypeface;
    private static Typeface mRobotoCondensedBoldTypeface;

    public static Typeface getRobotoThin(Context context) {
        if (mRobotoThinTypeface == null)
            mRobotoThinTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_thin.ttf");

        return mRobotoThinTypeface;
    }

    public static Typeface getRobotoLight(Context context) {
        if (mRobotoLightTypeface == null)
            mRobotoLightTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_light.ttf");

        return mRobotoLightTypeface;
    }

    public static Typeface getRobotoRegular(Context context) {
        if (mRobotoRegularTypeface == null)
            mRobotoRegularTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_regular.ttf");

        return mRobotoRegularTypeface;
    }

    public static Typeface getRobotoMediumBold(Context context) {
        if (mRobotoMediumTypeface == null)
            mRobotoMediumTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_medium.ttf");

        return mRobotoMediumTypeface;
    }

    public static Typeface getRobotoLightCondensed(Context context) {
        if (mRobotoCondensedLightTypeface == null)
            mRobotoCondensedLightTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_condensed_light.ttf");

        return mRobotoCondensedLightTypeface;
    }

    public static Typeface getRobotoRegularCondensed(Context context) {
        if (mRobotoCondensedRegularTypeface == null)
            mRobotoCondensedRegularTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_condensed_regular.ttf");

        return mRobotoCondensedRegularTypeface;
    }

    public static Typeface getRobotoCondensedBold(Context context) {
        if (mRobotoCondensedBoldTypeface == null)
            mRobotoCondensedBoldTypeface = Typeface.createFromAsset(context.getAssets(), "font/roboto_condensed_bold.ttf");

        return mRobotoCondensedBoldTypeface;
    }

}
