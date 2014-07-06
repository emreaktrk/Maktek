package akturk.maktek.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import akturk.maktek.R;
import akturk.maktek.fragment.FairHotelsFragment;
import akturk.maktek.fragment.FreeShuttleServicesFragment;
import akturk.maktek.fragment.VisitingInformationFragment;

public final class TransportationPagerAdapter extends FragmentPagerAdapter {
    private final String[] mSubTransportationArray;

    public TransportationPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mSubTransportationArray = context.getResources().getStringArray(R.array.sub_navigation_transportation_array);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case VisitingInformationFragment.SUB_POSITION:
                return new VisitingInformationFragment();
            case FairHotelsFragment.SUB_POSITION:
                return new FairHotelsFragment();
            case FreeShuttleServicesFragment.SUB_POSITION:
                return new FreeShuttleServicesFragment();
            default:
                throw new IllegalArgumentException("Unknown position. Make sure you have fragment to display.");
        }
    }


    @Override
    public int getCount() {
        return mSubTransportationArray.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSubTransportationArray[position];
    }
}
