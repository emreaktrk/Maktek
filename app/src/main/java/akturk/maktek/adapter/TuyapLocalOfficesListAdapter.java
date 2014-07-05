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


public class TuyapLocalOfficesListAdapter extends ArrayAdapter<Office> {
    private LayoutInflater mInflater;

    public TuyapLocalOfficesListAdapter(Context context, List<Office> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_tuyap_local_offices, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mNameTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_tuyap_local_offices_name_textview);
            tempViewHolder.mAdressTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_local_offices_adress_textview);
            tempViewHolder.mPhoneTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_local_offices_phone_textview);
            tempViewHolder.mFaxTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_local_offices_fax_textview);
            tempViewHolder.mMailTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_tuyap_local_offices_email_textview);
            tempViewHolder.mPhoneImageView = (VerticallySquaredImageView) convertView.findViewById(R.id.cell_tuyap_local_offices_phone_imageview);
            tempViewHolder.mMailImageView = (VerticallySquaredImageView) convertView.findViewById(R.id.cell_tuyap_local_offices_mail_imageview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();

        tempViewHolder.mNameTextView.setText(getItem(position).getName());
        tempViewHolder.mAdressTextView.setText(getItem(position).getAdress());
        tempViewHolder.mPhoneTextView.setText(getItem(position).getPhone());
        tempViewHolder.mFaxTextView.setText(getItem(position).getFax());
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
        RobotoCondensedRegularTextView mAdressTextView;
        RobotoCondensedRegularTextView mPhoneTextView;
        RobotoCondensedRegularTextView mFaxTextView;
        RobotoCondensedRegularTextView mMailTextView;
        VerticallySquaredImageView mPhoneImageView;
        VerticallySquaredImageView mMailImageView;
    }
}
