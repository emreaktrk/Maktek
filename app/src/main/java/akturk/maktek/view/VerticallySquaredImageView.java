package akturk.maktek.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class VerticallySquaredImageView extends ImageView {
    public VerticallySquaredImageView(Context context) {
        super(context);
    }

    public VerticallySquaredImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredHeight());
    }
}