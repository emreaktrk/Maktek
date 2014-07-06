package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;

import com.github.amlcurran.showcaseview.ShowcaseView;

import akturk.maktek.R;

public final class AboutTuyapFragment extends BaseFragment {
    public static final int POSITION = 6;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_about_tuyap;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getShowcaseTitleResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getShowcaseDetailResourceID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected long getShowcaseSingleShotID() {
        return ShowcaseView.NO_ID;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_about_tuyap;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
