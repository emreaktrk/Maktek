package akturk.maktek.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import akturk.maktek.global.MaktekApplication;

public final class RobotoMediumTextView extends TextView {

    public RobotoMediumTextView(Context context) {
        super(context);
        if (!isInEditMode())
            init();
    }

    public RobotoMediumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init();
    }

    public RobotoMediumTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            init();
    }

    private void init() {
        setTypeface(MaktekApplication.mTypefaceLoader.getRobotoMediumBold(getContext()));
    }
}
