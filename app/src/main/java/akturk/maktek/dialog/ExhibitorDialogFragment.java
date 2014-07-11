package akturk.maktek.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import akturk.maktek.R;
import akturk.maktek.dialog.BaseDialogFragment;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.view.RobotoCondensedBoldTextView;
import akturk.maktek.view.RobotoCondensedRegularTextView;

@SuppressLint("ValidFragment")
public final class ExhibitorDialogFragment extends BaseDialogFragment {
    private Exhibitor mExhibitor;
    private RobotoCondensedBoldTextView mNameTextView;
    private RobotoCondensedRegularTextView mPhoneTextView;
    private RobotoCondensedRegularTextView mWebsiteTextView;

    public ExhibitorDialogFragment(Exhibitor exhibitor) {
        this.mExhibitor = exhibitor;
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.fragment_dialog_list_of_exhibitor;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNameTextView = (RobotoCondensedBoldTextView) view.findViewById(R.id.fragment_dialog_list_of_exhibitors_name_textview);
        mNameTextView.setText(mExhibitor.getName());

        mPhoneTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.fragment_dialog_list_of_exhibitors_phone_textview);
        mPhoneTextView.setText(mExhibitor.getPhone());

        mWebsiteTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.fragment_dialog_list_of_exhibitors_website_textview);
        mWebsiteTextView.setText(mExhibitor.getWebsite());
    }
}
