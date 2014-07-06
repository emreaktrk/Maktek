package akturk.maktek.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import akturk.maktek.R;
import akturk.maktek.adapter.ContactPagerAdapter;

public class ContactFragment extends BaseFragment {
    public static final int POSITION = 6;

    private ViewPager mViewPager;
    private ContactPagerAdapter mAdapter;

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_contact;
    }

    @Override
    protected int getShowcaseTargetResourceID() {
        return R.id.fragment_contact_titlestrip;
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_contact;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new ContactPagerAdapter(getChildFragmentManager(), getActivity().getBaseContext());

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_contact_viewpager);
        mViewPager.setAdapter(mAdapter);
    }
}
