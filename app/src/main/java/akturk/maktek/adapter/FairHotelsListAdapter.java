package akturk.maktek.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import akturk.maktek.R;
import akturk.maktek.model.Hotel;
import akturk.maktek.view.RobotoCondensedBoldTextView;
import akturk.maktek.view.RobotoCondensedRegularTextView;
import akturk.maktek.view.SquaredCircleImageView;
import akturk.maktek.view.SquaredImageView;
import akturk.maktek.view.SquaredTextView;


public class FairHotelsListAdapter extends ArrayAdapter<Hotel> {
    private LayoutInflater mInflater;

    public FairHotelsListAdapter(Context context, List<Hotel> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_fair_hotels, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mNameTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_fair_hotels_name_textview);
            tempViewHolder.mHotelImageView = (SquaredCircleImageView) convertView.findViewById(R.id.cell_fair_hotels_hotel_imageview);
            tempViewHolder.mPhoneTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_fair_hotels_phone_textview);
            tempViewHolder.mLocationTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_fair_hotels_location_textview);
            tempViewHolder.mWebsiteTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_fair_hotels_website_textview);
            tempViewHolder.mStarTextView = (SquaredTextView) convertView.findViewById(R.id.cell_fair_hotels_star_textview);
            tempViewHolder.mPhoneImageView = (SquaredImageView) convertView.findViewById(R.id.cell_fair_hotels_phone_imageview);
            tempViewHolder.mWebSiteImageView = (SquaredImageView) convertView.findViewById(R.id.cell_fair_hotels_website_imageview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();

        tempViewHolder.mNameTextView.setText(getItem(position).getName().toUpperCase());
        tempViewHolder.mHotelImageView.setImageResource(getContext().getResources().getIdentifier(getItem(position).getImageName(), "drawable", getContext().getPackageName()));
        tempViewHolder.mPhoneTextView.setText(getItem(position).getPhone());
        tempViewHolder.mLocationTextView.setText(getItem(position).getLocation());
        tempViewHolder.mWebsiteTextView.setText(getItem(position).getWebsite());
        tempViewHolder.mStarTextView.setText(getItem(position).getStar());
        tempViewHolder.mPhoneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tempIntent = new Intent(Intent.ACTION_DIAL);
                tempIntent.setData(Uri.parse("tel:" + getItem(position).getPhone()));
                tempIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(tempIntent);
            }
        });
        tempViewHolder.mWebSiteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tempIntent = new Intent(Intent.ACTION_VIEW);
                tempIntent.setData(Uri.parse("http://" + Uri.parse(getItem(position).getWebsite())));
                tempIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(tempIntent);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        RobotoCondensedBoldTextView mNameTextView;
        SquaredCircleImageView mHotelImageView;
        RobotoCondensedRegularTextView mPhoneTextView;
        RobotoCondensedRegularTextView mLocationTextView;
        RobotoCondensedRegularTextView mWebsiteTextView;
        SquaredTextView mStarTextView;
        SquaredImageView mPhoneImageView;
        SquaredImageView mWebSiteImageView;
    }
}
