package akturk.maktek.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import akturk.maktek.R;
import akturk.maktek.adapter.PressPagerAdapter;

public final class PressFragment extends BaseFragment {
    public static final int POSITION = 4;

    private ViewPager mViewPager;
    private PressPagerAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_press;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return R.id.fragment_press_titlestrip;
    }

    @Override
    protected int getShowcaseTitleResourceID() {
        return R.string.showcase_title_titlestrip;
    }

    @Override
    protected int getShowcaseDetailResourceID() {
        return R.string.showcase_detail_titlestrip;
    }

    @Override
    protected long getShowcaseSingleShotID() {
        return SHOWCASE_SINGLESHOT_TITLESTRIP;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_press;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new PressPagerAdapter(getChildFragmentManager(), getActivity().getBaseContext());

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_press_viewpager);
        mViewPager.setAdapter(mAdapter);
    }
}
