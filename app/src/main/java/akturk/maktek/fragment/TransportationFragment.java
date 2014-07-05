package akturk.maktek.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import akturk.maktek.R;
import akturk.maktek.adapter.TransportationPagerAdapter;

public class TransportationFragment extends BaseFragment {
    public static final int POSITION = 4;

    private ViewPager mViewPager;
    private TransportationPagerAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_transportation;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return R.id.fragment_transportation_titlestrip;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_transportation;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new TransportationPagerAdapter(getChildFragmentManager(), getActivity().getBaseContext());

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_transportation_viewpager);
        mViewPager.setAdapter(mAdapter);
    }
}
