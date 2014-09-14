package akturk.maktek.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import akturk.maktek.interfaces.OnDialogFragmentDismissListener;

abstract class BaseDialogFragment extends DialogFragment {
    private OnDialogFragmentDismissListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        View rootView = inflater.inflate(getLayoutResourceID(), container, false);
        return rootView;
    }

    protected abstract int getLayoutResourceID();

    public void setOnDialogFragmentDismissListener(OnDialogFragmentDismissListener listener) {
        mListener = listener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        if (mListener == null)
            return;

        mListener.onDismiss();
    }
}
