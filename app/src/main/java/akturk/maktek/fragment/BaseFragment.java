package akturk.maktek.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import akturk.maktek.R;
import akturk.maktek.activity.HomeActivity;

abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResourceID(), container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setShowcase();
    }

    protected abstract int getLayoutResourceID();

    protected abstract int getShowcaseTargetResourceID();

    protected abstract int getShowcaseTitleResourceID();

    protected abstract int getShowcaseDetailResourceID();

    protected abstract long getShowcaseSingleShotID();

    private void setShowcase() {
        if (getShowcaseTargetResourceID() == ShowcaseView.NO_ID)
            return;

        new ShowcaseView.Builder(getActivity())
                .setTarget(new ViewTarget(getShowcaseTargetResourceID(), getActivity()))
                .setStyle(R.style.MaktekShowcase)
                .setContentTitle(getResources().getString(getShowcaseTitleResourceID()))
                .setContentText(getString(getShowcaseDetailResourceID()))
                .singleShot(getShowcaseSingleShotID())
                .build();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((HomeActivity) activity).setActionBarTitle(getActionBarTitle());
    }

    protected abstract int getActionBarTitle();
}
