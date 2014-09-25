package akturk.maktek.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import akturk.maktek.R;
import akturk.maktek.fragment.MibFragment;
import akturk.maktek.fragment.TiadFragment;

public final class TiadAndMibPagerAdapter extends FragmentPagerAdapter {
    private final String[] mSubTiadAndMibArray;

    public TiadAndMibPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mSubTiadAndMibArray = context.getResources().getStringArray(R.array.sub_navigation_tiad_and_mib_array);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TiadFragment.SUB_POSITION:
                return new TiadFragment();
            case MibFragment.SUB_POSITION:
                return new MibFragment();
            default:
                throw new IllegalArgumentException("Unknown position. Make sure you have fragment to display.");
        }
    }

    @Override
    public int getCount() {
        return mSubTiadAndMibArray.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSubTiadAndMibArray[position];
    }
}
