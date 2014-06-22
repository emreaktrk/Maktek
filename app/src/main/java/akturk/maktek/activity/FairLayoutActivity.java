package akturk.maktek.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;

import akturk.maktek.R;
import akturk.maktek.view.ZoomView;

public final class FairLayoutActivity extends BaseActivity {
    public static final int POSITION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fair_layout);

        setActionBarTypeface();
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ZoomView mZoomView = (ZoomView) findViewById(R.id.activity_fair_layout_zoomview);
        mZoomView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
