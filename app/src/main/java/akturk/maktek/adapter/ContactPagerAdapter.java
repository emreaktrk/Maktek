package akturk.maktek.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import akturk.maktek.R;
import akturk.maktek.fragment.FairMarketingGroupFragment;
import akturk.maktek.fragment.FairSalesGroupFragment;
import akturk.maktek.fragment.TuyapFragment;
import akturk.maktek.fragment.TuyapLocalOfficesFragment;
import akturk.maktek.fragment.TuyapOverseasOfficesFragment;

public class ContactPagerAdapter extends FragmentPagerAdapter {
    private final String[] mSubContactArray;

    public ContactPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mSubContactArray = context.getResources().getStringArray(R.array.sub_navigation_contact_array);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TuyapFragment.SUB_POSITION:
                return new TuyapFragment();
            case FairSalesGroupFragment.SUB_POSITION:
                return new FairSalesGroupFragment();
            case FairMarketingGroupFragment.SUB_POSITION:
                return new FairMarketingGroupFragment();
            case TuyapLocalOfficesFragment.SUB_POSITION:
                return new TuyapLocalOfficesFragment();
            case TuyapOverseasOfficesFragment.SUB_POSITION:
                return new TuyapOverseasOfficesFragment();
            default:
                throw new IllegalArgumentException("Unknown position. Make sure you have fragment to display.");
        }
    }


    @Override
    public int getCount() {
        return mSubContactArray.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSubContactArray[position];
    }
}
