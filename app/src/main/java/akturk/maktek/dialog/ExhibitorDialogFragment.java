package akturk.maktek.dialog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import akturk.maktek.R;
import akturk.maktek.activity.MapActivity;
import akturk.maktek.constant.Constants;
import akturk.maktek.global.MaktekApplication;
import akturk.maktek.model.Agenda;
import akturk.maktek.model.Category;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.AgendaIODataProvider;
import akturk.maktek.view.RobotoCondensedBoldTextView;
import akturk.maktek.view.RobotoCondensedRegularTextView;
import akturk.maktek.view.VerticallySquaredImageView;

@SuppressLint("ValidFragment")
public final class ExhibitorDialogFragment extends BaseDialogFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private Exhibitor mExhibitor;
    private RobotoCondensedBoldTextView mNameTextView;
    private RobotoCondensedRegularTextView mPhoneTextView;
    private RobotoCondensedRegularTextView mWebsiteTextView;
    private RobotoCondensedRegularTextView mLocationTextView;
    private RobotoCondensedRegularTextView mSaloonTextView;
    private RobotoCondensedRegularTextView mStandTextView;
    private RobotoCondensedRegularTextView mCategoryTextView;
    private VerticallySquaredImageView mLocationImageView;
    private VerticallySquaredImageView mWebsiteImageView;
    private VerticallySquaredImageView mPhoneImageView;
    private CheckBox mFavouriteCheckBox;
    private View mBackgroundView;
    private AgendaIODataProvider mProvider;
    private Category mCategory;

    public ExhibitorDialogFragment(Exhibitor exhibitor) {
        this.mExhibitor = exhibitor;
    }

    @Override
    protected int getLayoutResourceID() {
        return R.layout.dialog_list_of_exhibitor;
    }

    @Deprecated
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCategory = Category.getInstance(mExhibitor);

        mBackgroundView = view.findViewById(R.id.dialog_list_of_exhibitors_backgroundview);
        mBackgroundView.setBackgroundDrawable(getCategoryColor());

        mNameTextView = (RobotoCondensedBoldTextView) view.findViewById(R.id.dialog_list_of_exhibitors_name_textview);
        mNameTextView.setText(mExhibitor.getName());

        mPhoneTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_phone_textview);
        mPhoneTextView.setText(mExhibitor.getPhone());

        mPhoneImageView = (VerticallySquaredImageView) view.findViewById(R.id.dialog_list_of_exhibitors_phone_imageview);
        mPhoneImageView.setOnClickListener(this);

        mWebsiteTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_website_textview);
        mWebsiteTextView.setText(mExhibitor.getWebsite());

        mWebsiteImageView = (VerticallySquaredImageView) view.findViewById(R.id.dialog_list_of_exhibitors_website_imageview);
        mWebsiteImageView.setOnClickListener(this);

        mLocationImageView = (VerticallySquaredImageView) view.findViewById(R.id.dialog_list_of_exhibitors_location_imageview);
        mLocationImageView.setOnClickListener(this);

        mLocationTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_location_textview);
        mLocationTextView.setText(mExhibitor.getAdress());

        mLocationImageView = (VerticallySquaredImageView) view.findViewById(R.id.dialog_list_of_exhibitors_location_imageview);
        mLocationImageView.setOnClickListener(this);

        mFavouriteCheckBox = (CheckBox) view.findViewById(R.id.dialog_list_of_exhibitors_favourite_checkbox);
        mFavouriteCheckBox.setChecked(mExhibitor.isFavourite());
        mFavouriteCheckBox.setOnCheckedChangeListener(this);

        mSaloonTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_saloon_textview);
        mSaloonTextView.setText(String.format(getString(R.string.text_saloon), mExhibitor.getSaloonNo()));

        mStandTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_stand_textview);
        mStandTextView.setText(String.format(getString(R.string.text_stand), mExhibitor.getStandNo()));

        mCategoryTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_category_textview);
        mCategoryTextView.setText(mCategory.getName(getActivity().getBaseContext()));
        mCategoryTextView.setBackgroundDrawable(getCategoryColor());

        mProvider = MaktekApplication.getAgendaIODataProvider();
    }

    @Override
    public void onCheckedChanged(CompoundButton view, boolean isChecked) {
        mExhibitor.setFavourite(isChecked);
        Agenda tempAgenda = new Agenda(mExhibitor);

        if (isChecked)
            mProvider.add(tempAgenda);
        else
            mProvider.remove(tempAgenda);

        mProvider.save(mProvider.getList());
    }

    private ColorDrawable getCategoryColor() {
        int tempColor = getResources().getColor(mCategory.getColorResouce());
        ColorDrawable tempColorDrawable = new ColorDrawable(tempColor);

        return tempColorDrawable;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_list_of_exhibitors_location_imageview:
                openMapIntent();
                return;
            case R.id.dialog_list_of_exhibitors_phone_imageview:
                openDiallerIntent();
                return;
            case R.id.dialog_list_of_exhibitors_website_imageview:
                openBrowserIntent();
                return;
        }
    }

    private void openMapIntent() {
        if (TextUtils.isEmpty(mExhibitor.getLatitude()) || TextUtils.isEmpty(mExhibitor.getLongitude()))
            return;

        Intent mapIntent = new Intent(getActivity().getBaseContext(), MapActivity.class);
        mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mapIntent.putExtra(Constants.EXHIBITOR, mExhibitor);
        startActivity(mapIntent);
    }

    private void openDiallerIntent() {
        if (TextUtils.isEmpty(mExhibitor.getPhone()))
            return;

        Intent tempIntent = new Intent(Intent.ACTION_DIAL);
        tempIntent.setData(Uri.parse("tel:" + mExhibitor.getPhone()));
        tempIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(tempIntent);
    }

    private void openBrowserIntent() {
        if (TextUtils.isEmpty(mExhibitor.getWebsite()))
            return;

        Intent tempIntent = new Intent(Intent.ACTION_VIEW);
        tempIntent.setData(Uri.parse("http://" + Uri.parse(mExhibitor.getWebsite())));
        tempIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(tempIntent);
    }
}
