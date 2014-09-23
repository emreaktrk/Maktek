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


public final class FairMarketingGroupListAdapter extends ArrayAdapter<Office> {
    private LayoutInflater mInflater;

    public FairMarketingGroupListAdapter(Context context, List<Office> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_fair_marketing_group, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mTitleTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_fair_marketing_group_title_textview);
            tempViewHolder.mNameTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_fair_marketing_group_name_textview);
            tempViewHolder.mPhoneTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_fair_marketing_group_phone_textview);
            tempViewHolder.mMailTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_fair_marketing_group_email_textview);
            tempViewHolder.mMailImageView = (VerticallySquaredImageView) convertView.findViewById(R.id.cell_fair_marketing_group_email_imageview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();

        tempViewHolder.mTitleTextView.setText(getItem(position).getTitle());
        tempViewHolder.mNameTextView.setText(getItem(position).getName());
        tempViewHolder.mPhoneTextView.setText(getItem(position).getPhone());
        tempViewHolder.mMailTextView.setText(getItem(position).getEmail());
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
        RobotoCondensedBoldTextView mTitleTextView;
        RobotoCondensedRegularTextView mNameTextView;
        RobotoCondensedRegularTextView mPhoneTextView;
        RobotoCondensedRegularTextView mMailTextView;
        VerticallySquaredImageView mMailImageView;
    }
}
