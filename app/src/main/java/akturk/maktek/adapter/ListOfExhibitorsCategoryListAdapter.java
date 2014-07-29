package akturk.maktek.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import akturk.maktek.R;
import akturk.maktek.interfaces.OnExhibitorClickListener;
import akturk.maktek.model.Category;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.view.RobotoCondensedBoldTextView;

public final class ListOfExhibitorsCategoryListAdapter extends ArrayAdapter<Exhibitor> implements Filterable {
    private LayoutInflater mInflater;
    private OnExhibitorClickListener mListener;
    private ListOfExhibitorFilter mFilter;
    private List<Exhibitor> mOriginalList;
    private List<Exhibitor> mFilteredList;

    public ListOfExhibitorsCategoryListAdapter(Context context, List<Exhibitor> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
        mOriginalList = objects;
        mFilteredList = objects;
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

    @Override
    public Exhibitor getItem(int position) {
        return mFilteredList.get(position);
    }

    @Override
    public int getCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {
        if (mFilter == null)
            mFilter = new ListOfExhibitorFilter();

        return mFilter;
    }

    private static class ViewHolder {
        RobotoCondensedBoldTextView mNameTextView;
        View mClickView;
    }

    public void setOnExhibitorClickListener(OnExhibitorClickListener callback) {
        this.mListener = callback;
    }

    private class ListOfExhibitorFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Category tempCategory = Category.getInstance(constraint.toString());
            ArrayList<Exhibitor> tempFilteredList = new ArrayList<Exhibitor>();

            for (Exhibitor tempExhibitor : mOriginalList)
                for (String tempSaloon : tempCategory.getSaloons())
                    if (TextUtils.equals(tempExhibitor.getSaloonNo(), tempSaloon)) {
                        tempFilteredList.add(tempExhibitor);
                        continue;
                    }

            FilterResults tempResults = new FilterResults();
            tempResults.values = tempFilteredList;
            tempResults.count = tempFilteredList.size();
            return tempResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFilteredList = (ArrayList<Exhibitor>) results.values;
            notifyDataSetChanged();
        }
    }
}
