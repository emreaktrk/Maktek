package akturk.maktek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ViewFlipper;

import java.util.List;

import akturk.maktek.R;
import akturk.maktek.model.Paragraph;
import akturk.maktek.view.RobotoCondensedBoldTextView;
import akturk.maktek.view.RobotoCondensedRegularTextView;

public final class HomeListAdapter extends ArrayAdapter<Paragraph> {
    private LayoutInflater mInflater;

    public HomeListAdapter(Context context, List<Paragraph> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position == 0)
            return inflateHeader(parent);

        convertView = mInflater.inflate(R.layout.cell_home, parent, false);
        RobotoCondensedBoldTextView mTitleTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_home_title_textview);
        RobotoCondensedRegularTextView mContentTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_home_content_textview);

        mTitleTextView.setText(getItem(position).getTitle());
        mContentTextView.setText(getItem(position).getContent());

        return convertView;
    }

    private View inflateHeader(ViewGroup parent) {
        View tempView = mInflater.inflate(R.layout.cell_home_header, parent, false);

        ViewFlipper tempViewFlipper = (ViewFlipper) tempView.findViewById(R.id.fragment_home_viewflipper);
        tempViewFlipper.startFlipping();

        return tempView;
    }
}
