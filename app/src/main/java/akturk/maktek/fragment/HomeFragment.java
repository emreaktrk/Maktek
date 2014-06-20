package akturk.maktek.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import akturk.maktek.R;

public class HomeFragment extends BaseFragment {
    private ViewFlipper mFlipper;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_home;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_home;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFlipper = (ViewFlipper) view.findViewById(R.id.fragment_home_viewflipper);
        mFlipper.startFlipping();
    }


}
