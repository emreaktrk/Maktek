package akturk.maktek.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import akturk.maktek.R;
import akturk.maktek.model.Category;
import akturk.maktek.view.RobotoCondensedBoldTextView;

public class CategoryArrayAdapter extends ArrayAdapter<Category> {
    private List<Category> mCategories;
    private LayoutInflater mInflater;

    public CategoryArrayAdapter(Context context) {
        super(context, android.R.layout.simple_spinner_dropdown_item);
        mInflater = LayoutInflater.from(getContext());
        initCategories();
    }

    private List<Category> initCategories() {
        mCategories = new ArrayList<Category>();

        for (Category tempCategory : Category.values())
            mCategories.add(tempCategory);

        return mCategories;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;
        Category tempCategory = getItem(position);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_category, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mNameTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_category_name_textview);
            tempViewHolder.mSaloonView = convertView.findViewById(R.id.cell_category_saloonview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();


        tempViewHolder.mNameTextView.setText(tempCategory.getName());
        tempViewHolder.mSaloonView.setBackgroundDrawable(getSaloonColor(tempCategory));

        return convertView;
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    public int getSize() {
        return mCategories.size() - 1;
    }

    @Override
    public Category getItem(int position) {
        return mCategories.get(position);
    }

    private ColorDrawable getSaloonColor(Category category) {
        int tempColor = getContext().getResources().getColor(category.getColorResouce());
        return new ColorDrawable(tempColor);
    }

    private static class ViewHolder {
        RobotoCondensedBoldTextView mNameTextView;
        View mSaloonView;
    }
}
