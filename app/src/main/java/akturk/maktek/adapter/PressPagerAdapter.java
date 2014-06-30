package akturk.maktek.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import akturk.maktek.R;
import akturk.maktek.fragment.MaktekOnPressFragment;
import akturk.maktek.fragment.MediaPartnersFragment;
import akturk.maktek.fragment.PressReleaseFragment;

public class PressPagerAdapter extends FragmentPagerAdapter {
    private final String[] mSubPressArray;

    public PressPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mSubPressArray = context.getResources().getStringArray(R.array.sub_navigation_press_array);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PressReleaseFragment.SUB_POSITION:
                return new PressReleaseFragment();
            case MediaPartnersFragment.SUB_POSITION:
                return new MediaPartnersFragment();
            default:
                throw new IllegalArgumentException("Unknown position. Make sure you have fragment to display.");
        }
    }


    @Override
    public int getCount() {
        return mSubPressArray.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSubPressArray[position];
    }
}
