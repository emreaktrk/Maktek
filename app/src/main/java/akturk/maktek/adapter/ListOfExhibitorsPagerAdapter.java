package akturk.maktek.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import akturk.maktek.R;
import akturk.maktek.fragment.FairHotelsFragment;
import akturk.maktek.fragment.FreeShuttleServicesFragment;
import akturk.maktek.fragment.ListOfExhibitorsCategoryFragment;
import akturk.maktek.fragment.ListOfExhibitorsSearchFragment;
import akturk.maktek.fragment.VisitingInformationFragment;

public final class ListOfExhibitorsPagerAdapter extends FragmentPagerAdapter {
    private final String[] mSubExhibitorsArray;

    public ListOfExhibitorsPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mSubExhibitorsArray = context.getResources().getStringArray(R.array.sub_navigation_exhibitors_array);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case ListOfExhibitorsSearchFragment.SUB_POSITION:
                return new ListOfExhibitorsSearchFragment();
            case ListOfExhibitorsCategoryFragment.SUB_POSITION:
                return new ListOfExhibitorsCategoryFragment();
            default:
                throw new IllegalArgumentException("Unknown position. Make sure you have fragment to display.");
        }
    }

    @Override
    public int getCount() {
        return mSubExhibitorsArray.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSubExhibitorsArray[position];
    }
}
