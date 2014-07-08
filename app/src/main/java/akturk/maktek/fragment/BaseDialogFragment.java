package akturk.maktek.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import akturk.maktek.view.RobotoCondensedBoldTextView;

abstract class BaseDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        View rootView = inflater.inflate(getLayoutResourceID(), container, false);
        return rootView;
    }

    protected abstract int getLayoutResourceID();

}
