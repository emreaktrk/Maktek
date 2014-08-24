package akturk.maktek.dialog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import akturk.maktek.R;
import akturk.maktek.activity.MapActivity;
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

        mCategoryTextView = (RobotoCondensedRegularTextView) view.findViewById(R.id.dialog_list_of_exhibitors_category_textview);
        mCategoryTextView.setText(mCategory.getName(getActivity().getBaseContext()));

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_list_of_exhibitors_location_imageview:
                openMapIntent();
                break;
            case R.id.dialog_list_of_exhibitors_phone_imageview:
                openDiallerIntent();
                break;
            case R.id.dialog_list_of_exhibitors_website_imageview:
                openBrowserIntent();
                break;
        }

    }

    private void openMapIntent() {
//        Intent tempIntent = new Intent(Intent.ACTION_VIEW);
//        Uri tempUri = Uri.parse("geo:0,0?q=" + mExhibitor.getLatitude() + "," + mExhibitor.getLongitude() + "(" + mExhibitor.getCompany() + ")");
//        tempIntent.setData(tempUri);
//        startActivity(tempIntent);

        Intent mapIntent = new Intent(getActivity().getBaseContext(), MapActivity.class);
        mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mapIntent.putExtra("X", mExhibitor.getLatitude());
        mapIntent.putExtra("Y", mExhibitor.getLongitude());
        startActivity(mapIntent);
    }

    private void openDiallerIntent() {
        Intent tempIntent = new Intent(Intent.ACTION_DIAL);
        tempIntent.setData(Uri.parse("tel:" + mExhibitor.getPhone()));
        tempIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(tempIntent);
    }

    private void openBrowserIntent() {
        Intent tempIntent = new Intent(Intent.ACTION_VIEW);
        tempIntent.setData(Uri.parse("http://" + Uri.parse(mExhibitor.getWebsite())));
        tempIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(tempIntent);
    }
}
