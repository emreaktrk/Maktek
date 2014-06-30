package akturk.maktek.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class HorizantallySquaredImageView extends ImageView {

    public HorizantallySquaredImageView(Context context) {
        super(context);
    }

    public HorizantallySquaredImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}