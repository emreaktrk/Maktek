package akturk.maktek.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import akturk.maktek.R;
import akturk.maktek.model.Shuttle;
import akturk.maktek.view.RobotoCondensedBoldTextView;
import akturk.maktek.view.RobotoCondensedRegularTextView;


public final class FreeShuttleServicesListAdapter extends ArrayAdapter<Shuttle> {
    private LayoutInflater mInflater;

    public FreeShuttleServicesListAdapter(Context context, List<Shuttle> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_free_shuttle_services, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mNameTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_free_shuttle_services_name_textview);
            tempViewHolder.mDepartureTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_free_shuttle_services_departure_textview);
            tempViewHolder.mReturnTextView = (RobotoCondensedRegularTextView) convertView.findViewById(R.id.cell_free_shuttle_services_return_textview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();

        tempViewHolder.mNameTextView.setText(getItem(position).getName());
        tempViewHolder.mDepartureTextView.setText(getItem(position).getDeparture());
        tempViewHolder.mReturnTextView.setText(getItem(position).getReturn());

        return convertView;
    }

    private static class ViewHolder {
        RobotoCondensedBoldTextView mNameTextView;
        RobotoCondensedRegularTextView mDepartureTextView;
        RobotoCondensedRegularTextView mReturnTextView;
    }
}
