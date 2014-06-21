package akturk.maktek.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import akturk.maktek.R;
import akturk.maktek.model.NavigationDrawerItem;
import akturk.maktek.view.RobotoThinTextView;

public class NavigationDrawerListAdapter extends ArrayAdapter<NavigationDrawerItem> {
    private static class ViewHolder {
        ImageView mImageView;
        RobotoThinTextView mTextView;
    }

    private int mResouce;
    private LayoutInflater mInflater;

    public NavigationDrawerListAdapter(Context context, int resource, List<NavigationDrawerItem> objects) {
        super(context, resource, objects);
        mResouce = resource;
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(mResouce, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mTextView = (RobotoThinTextView) convertView.findViewById(R.id.cell_navigation_drawer_textview);
            tempViewHolder.mImageView = (ImageView) convertView.findViewById(R.id.cell_navigation_drawer_imageview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();

        tempViewHolder.mTextView.setText(getItem(position).getLabel());
        tempViewHolder.mImageView.setImageResource(getItem(position).getIconResouce());

        return convertView;
    }
}
