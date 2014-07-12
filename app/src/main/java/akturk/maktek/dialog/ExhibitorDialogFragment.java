package akturk.maktek.dialog;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import akturk.maktek.R;
import akturk.maktek.global.MaktekApplication;
import akturk.maktek.model.Agenda;
import akturk.maktek.model.Category;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.AgendaIODataProvider;
import akturk.maktek.view.RobotoCondensedBoldTextView;
import akturk.maktek.view.RobotoCondensedRegularTextView;

@SuppressLint("ValidFragment")
public final class ExhibitorDialogFragment extends BaseDialogFragment implements CompoundButton.OnCheckedChangeListener {
    private Exhibitor mExhibitor;
    private RobotoCondensedBoldTextView mNameTextView;
    private RobotoCondensedRegularTextView mPhoneTextView;
    private RobotoCondensedRegularTextView mWebsiteTextView;
    private CheckBox mFavouriteCheckBox;
    private View mBackgroundView;
    private AgendaIODataProvider mProvider;
    private Category mCategory;

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

        mCategory = Category.getInstance(mExhibitor);

        mBackgroundView = view.findViewById(R.id.dialog_list_of_exhibitors_backgroundview);
        setBackgroundView();

        mNameTextView = (RobotoCondensedBoldTextView) view.findViewById(R.id.dialog_list_of_exhibitors_name_textview);
        mNameTextView.setText(mExhibitor.getName());

        mPhoneTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_phone_textview);
        mPhoneTextView.setText(mExhibitor.getPhone());

        mWebsiteTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_website_textview);
        mWebsiteTextView.setText(mExhibitor.getWebsite());

        mFavouriteCheckBox = (CheckBox) view.findViewById(R.id.dialog_list_of_exhibitors_favourite_checkbox);
        mFavouriteCheckBox.setChecked(mExhibitor.isFavourite());

        mFavouriteCheckBox.setOnCheckedChangeListener(this);

        mProvider = MaktekApplication.getAgendaIODataProvider();
    }

    @Override
    public void onCheckedChanged(CompoundButton view, boolean isChecked) {
        Agenda tempAgenda = new Agenda(mExhibitor);
        mExhibitor.setFavourite(isChecked);

        if (isChecked)
            mProvider.add(tempAgenda);
        else
            mProvider.remove(tempAgenda);

        mProvider.save(mProvider.getList());
    }

    private void setBackgroundView() {
        int tempColor = getResources().getColor(mCategory.getColorResouce());
        ColorDrawable tempColorDrawable = new ColorDrawable(tempColor);
        mBackgroundView.setBackgroundDrawable(tempColorDrawable);
    }
}
