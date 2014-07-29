package akturk.maktek.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import akturk.maktek.R;
import akturk.maktek.adapter.ListOfExhibitorsPagerAdapter;
import akturk.maktek.constant.SingleShotID;

public final class ListOfExhibitorsFragment extends BaseFragment {
    public static final int POSITION = 1;

    private ViewPager mViewPager;
    private ListOfExhibitorsPagerAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_list_of_exhibitors;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return R.id.fragment_list_of_exhibitors_tabstrip;
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
        return SingleShotID.SHOWCASE_SINGLESHOT_TITLESTRIP;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_list_of_exhibitors;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new ListOfExhibitorsPagerAdapter(getChildFragmentManager(), getActivity().getBaseContext());

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_list_of_exhibitors_viewpager);
        mViewPager.setAdapter(mAdapter);

        PagerSlidingTabStrip mTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.fragment_list_of_exhibitors_tabstrip);
        mTabStrip.setViewPager(mViewPager);
    }
}
