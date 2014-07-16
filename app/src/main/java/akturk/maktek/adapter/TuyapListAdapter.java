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
import akturk.maktek.model.Office;
import akturk.maktek.view.RobotoCondensedBoldTextView;
import akturk.maktek.view.RobotoCondensedRegularTextView;
import akturk.maktek.view.VerticallySquaredImageView;


public final class TuyapListAdapter extends ArrayAdapter<Office> {
    private LayoutInflater mInflater;

    public TuyapListAdapter(Context context, List<Office> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_tuyap, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mNameTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_tuyap_name_textview);
            tempViewHolder.mAdressTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_adress_textview);
            tempViewHolder.mPhoneTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_phone_textview);
            tempViewHolder.mFaxTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_fax_textview);
            tempViewHolder.mWebsiteTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_website_textview);
            tempViewHolder.mMailTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_email_textview);
            tempViewHolder.mPhoneImageView = (VerticallySquaredImageView) convertView.findViewById(R.id.cell_tuyap_phone_imageview);
            tempViewHolder.mMailImageView = (VerticallySquaredImageView) convertView.findViewById(R.id.cell_tuyap_email_imageview);
            tempViewHolder.mWebSiteImageView = (VerticallySquaredImageView) convertView.findViewById(R.id.cell_tuyap_website_imageview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();

        tempViewHolder.mNameTextView.setText(getItem(position).getName().toUpperCase());
        tempViewHolder.mPhoneTextView.setText(getItem(position).getPhone());
        tempViewHolder.mFaxTextView.setText(getItem(position).getFax());
        tempViewHolder.mAdressTextView.setText(getItem(position).getAdress());
        tempViewHolder.mWebsiteTextView.setText(getItem(position).getWebsite());
        tempViewHolder.mMailTextView.setText(getItem(position).getEmail());
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
        tempViewHolder.mMailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tempIntent = new Intent(Intent.ACTION_SENDTO);
                tempIntent.setData(Uri.fromParts("mailto", getItem(position).getEmail(), null));
                tempIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(tempIntent);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        RobotoCondensedBoldTextView mNameTextView;
        RobotoCondensedRegularTextView mPhoneTextView;
        RobotoCondensedRegularTextView mFaxTextView;
        RobotoCondensedRegularTextView mAdressTextView;
        RobotoCondensedRegularTextView mWebsiteTextView;
        RobotoCondensedRegularTextView mMailTextView;
        VerticallySquaredImageView mPhoneImageView;
        VerticallySquaredImageView mMailImageView;
        VerticallySquaredImageView mWebSiteImageView;
    }
}
