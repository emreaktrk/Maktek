package akturk.maktek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import akturk.maktek.R;
import akturk.maktek.model.Paragraph;
import akturk.maktek.view.RobotoCondensedBoldTextView;
import akturk.maktek.view.RobotoCondensedRegularTextView;

public final class AboutTuyapListAdapter extends ArrayAdapter<Paragraph> {
    private LayoutInflater mInflater;

    public AboutTuyapListAdapter(Context context, List<Paragraph> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.cell_about_tuyap, parent, false);
        RobotoCondensedBoldTextView mTitleTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_about_tuyap_title_textview);
        RobotoCondensedRegularTextView mContentTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_about_tuyap_content_textview);

        mTitleTextView.setText(getItem(position).getTitle());
        mContentTextView.setText(getItem(position).getContent());

        return convertView;
    }


}
