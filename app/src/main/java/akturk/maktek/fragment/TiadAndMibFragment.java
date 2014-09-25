package akturk.maktek.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.github.amlcurran.showcaseview.ShowcaseView;

import akturk.maktek.R;
import akturk.maktek.adapter.PressPagerAdapter;
import akturk.maktek.adapter.TiadAndMibPagerAdapter;
import akturk.maktek.constant.SingleShotID;

public final class TiadAndMibFragment extends BaseFragment {
    public static final int POSITION = 7;

    private ViewPager mViewPager;
    private TiadAndMibPagerAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_tiad_and_mib;
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
        return SingleShotID.SHOWCASE_SINGLESHOT_TITLESTRIP;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_tiad_and_mib;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new TiadAndMibPagerAdapter(getChildFragmentManager(), getActivity().getBaseContext());

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_tiad_and_mib_viewpager);
        mViewPager.setAdapter(mAdapter);

        PagerSlidingTabStrip mTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.fragment_tiad_and_mib_tabstrip);
        mTabStrip.setViewPager(mViewPager);
    }
}
