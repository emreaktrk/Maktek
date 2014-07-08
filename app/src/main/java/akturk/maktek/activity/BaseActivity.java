package akturk.maktek.activity;

import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;

import akturk.maktek.R;
import akturk.maktek.view.RobotoCondensedBoldTextView;

abstract class BaseActivity extends FragmentActivity {
    private RobotoCondensedBoldTextView mCustomActionBarTitle;

    protected final void setCustomActionBar() {
        setTitle("");
        View viewActionBar = getLayoutInflater().inflate(R.layout.cell_actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.RIGHT);
        mCustomActionBarTitle = (RobotoCondensedBoldTextView) viewActionBar.findViewById(R.id.actionbar_textview);
        getActionBar().setCustomView(viewActionBar, params);
        getActionBar().setDisplayShowCustomEnabled(true);
    }

    protected void setCustomTitle(CharSequence title) {
        mCustomActionBarTitle.setText(title);
    }
}
