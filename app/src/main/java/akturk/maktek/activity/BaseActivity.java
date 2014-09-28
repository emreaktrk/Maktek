package akturk.maktek.activity;

import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import akturk.maktek.R;
import akturk.maktek.view.RobotoCondensedBoldTextView;

abstract class BaseActivity extends FragmentActivity {
    private RobotoCondensedBoldTextView mCustomActionBarTitle;

    protected final void setCustomActionBar() {
        setTitle("");
        View mView = getLayoutInflater().inflate(R.layout.cell_actionbar, null);
        mCustomActionBarTitle = (RobotoCondensedBoldTextView) mView.findViewById(R.id.actionbar_textview);

        ActionBar.LayoutParams mParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.RIGHT);
        getActionBar().setCustomView(mView, mParams);
        getActionBar().setDisplayShowCustomEnabled(true);
    }

    protected void setCustomTitle(CharSequence title) {
        mCustomActionBarTitle.setText(title);
    }
}
