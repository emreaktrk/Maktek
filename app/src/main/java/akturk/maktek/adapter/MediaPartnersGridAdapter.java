package akturk.maktek.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import akturk.maktek.R;

public final class MediaPartnersGridAdapter extends ArrayAdapter<Drawable> {
    private LayoutInflater mInflater;

    public MediaPartnersGridAdapter(Context context, Drawable[] objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = mInflater.inflate(R.layout.cell_media_partners, parent, false);

        ((ImageView) convertView).setImageDrawable(getItem(position));

        return convertView;
    }
}
