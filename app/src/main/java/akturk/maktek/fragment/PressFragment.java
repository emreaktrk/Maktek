package akturk.maktek.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import akturk.maktek.R;
import akturk.maktek.adapter.PressPagerAdapter;

public class PressFragment extends BaseFragment {
    public static final int POSITION = 3;

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
