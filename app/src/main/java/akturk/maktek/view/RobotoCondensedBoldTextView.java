package akturk.maktek.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import akturk.maktek.global.MaktekApplication;

public final class RobotoCondensedBoldTextView extends TextView {

    public RobotoCondensedBoldTextView(Context context) {
        super(context);
        if (!isInEditMode())
            init();
    }

    public RobotoCondensedBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init();
    }

    public RobotoCondensedBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            init();
    }

    private void init() {
        setTypeface(MaktekApplication.mTypefaceLoader.getRobotoCondensedBold(getContext()));
    }
}
