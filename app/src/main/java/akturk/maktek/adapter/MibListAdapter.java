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

public final class MibListAdapter extends ArrayAdapter<Paragraph> {
    private LayoutInflater mInflater;

    public MibListAdapter(Context context, List<Paragraph> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.cell_mib, parent, false);
        RobotoCondensedBoldTextView mTitleTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_mib_title_textview);
        RobotoCondensedRegularTextView mContentTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_mib_content_textview);

        mTitleTextView.setText(getItem(position).getTitle());
        mContentTextView.setText(getItem(position).getContent());

        return convertView;
    }


}
