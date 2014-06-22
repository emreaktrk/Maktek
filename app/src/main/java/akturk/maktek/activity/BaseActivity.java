package akturk.maktek.activity;

import android.app.Activity;
import android.widget.TextView;

import akturk.maktek.R;
import akturk.maktek.global.MaktekApplication;

abstract class BaseActivity extends Activity{

    protected final void setActionBarTypeface() {
        int actionBarTitle = getResources().getSystem().getIdentifier("action_bar_title", "id", "android");
        TextView actionBarTitleView = (TextView) getWindow().findViewById(actionBarTitle);
        actionBarTitleView.setTypeface(MaktekApplication.mTypefaceLoader.getRobotoCondensedBold(getApplicationContext()));
        actionBarTitleView.setTextSize(getResources().getDimension(R.dimen.action_bar_text_size));
    }
}
