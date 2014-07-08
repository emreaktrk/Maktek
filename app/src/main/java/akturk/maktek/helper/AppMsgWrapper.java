package akturk.maktek.helper;

import android.app.Activity;
import android.view.Gravity;

import com.devspark.appmsg.AppMsg;

public class AppMsgWrapper {
    private AppMsg mAppMsg;
    private Activity mActivity;

    public AppMsgWrapper(Activity activity) {
        this.mActivity = activity;
    }

    public void makeText(final int resId, final AppMsg.Style style) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mAppMsg != null && mAppMsg.isShowing())
                    mAppMsg.cancel();

                mAppMsg = AppMsg.makeText(mActivity, resId, style);
                mAppMsg.setDuration(500);
                mAppMsg.setLayoutGravity(Gravity.BOTTOM);
                mAppMsg.show();
            }
        });
    }
}
