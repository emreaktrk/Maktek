package akturk.maktek.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import akturk.maktek.activity.HomeActivity;

abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResourceID(), container, false);
        return rootView;
    }

    protected abstract int getLayoutResourceID();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).setActionBarTitle(getActionBarTitle());
    }

    protected abstract int getActionBarTitle();


}
