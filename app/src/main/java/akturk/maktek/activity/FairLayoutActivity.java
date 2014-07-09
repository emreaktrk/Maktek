package akturk.maktek.activity;

import android.os.Bundle;
import android.view.MenuItem;

import akturk.maktek.R;
import uk.co.senab.photoview.PhotoView;

public final class FairLayoutActivity extends BaseActivity {
    public static final int POSITION = 2;

    private PhotoView mImageViewTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomActionBar();
        setContentView(R.layout.layout_fair_layout);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        setCustomTitle(getString(R.string.title_fair_layout));

        mImageViewTouch.setImageResource(R.drawable.ic_launcher);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        mImageViewTouch = (PhotoView) findViewById(R.id.activity_fair_layout_photoview);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
