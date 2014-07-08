package akturk.maktek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import akturk.maktek.R;
import akturk.maktek.interfaces.OnExhibitorClickListener;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.view.RobotoCondensedBoldTextView;

public final class ListOfExhibitorsListAdapter extends ArrayAdapter<Exhibitor> {
    private LayoutInflater mInflater;
    private OnExhibitorClickListener mListener;

    public ListOfExhibitorsListAdapter(Context context, List<Exhibitor> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_list_of_exhibitor, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mNameTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_list_of_exhibitors_name_textview);
            tempViewHolder.mClickView = convertView.findViewById(R.id.cell_list_of_exhibitors_clickview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();

        tempViewHolder.mNameTextView.setText(getItem(position).getName());
        tempViewHolder.mClickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener == null)
                    return;

                mListener.onExhibitorClick(getItem(position));
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        RobotoCondensedBoldTextView mNameTextView;
        View mClickView;
    }

    public void setOnExhibitorClickListener(OnExhibitorClickListener callback) {
        this.mListener = callback;
    }
}
