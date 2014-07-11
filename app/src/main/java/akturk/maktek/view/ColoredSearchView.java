package akturk.maktek.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.SearchView;

public class ColoredSearchView extends SearchView {

    public ColoredSearchView(Context context) {
        super(context);
        if (!isInEditMode())
            init();
    }

    public ColoredSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init();
    }

    private void init() {
        int tempSearchPlateID = getResources().getIdentifier("android:id/search_plate", null, null);
        ViewGroup tempViewGroup = (ViewGroup) findViewById(tempSearchPlateID);
        tempViewGroup.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
    }

    private void setSolidColor(ViewGroup viewGroup, String color) {
        int iColor = Color.parseColor(color);

        int red = (iColor & 0xFF0000) / 0xFFFF;
        int green = (iColor & 0xFF00) / 0xFF;
        int blue = iColor & 0xFF;

        float[] matrix = {0, 0, 0, 0, red
                , 0, 0, 0, 0, green
                , 0, 0, 0, 0, blue
                , 0, 0, 0, 1, 0};

        ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
        viewGroup.getBackground().setColorFilter(colorFilter);
    }
}
