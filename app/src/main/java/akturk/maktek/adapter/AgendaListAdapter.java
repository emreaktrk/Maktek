package akturk.maktek.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import akturk.maktek.R;
import akturk.maktek.interfaces.OnExhibitorClickListener;
import akturk.maktek.model.Agenda;
import akturk.maktek.model.Category;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.view.RobotoCondensedBoldTextView;

public class AgendaListAdapter extends ArrayAdapter<Agenda> {
    private LayoutInflater mInflater;
    private OnExhibitorClickListener mListener;

    public AgendaListAdapter(Context context, List<Agenda> objects) {
        super(context, 0, objects);
        mInflater = LayoutInflater.from(getContext());
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder tempViewHolder;
        final Exhibitor tempExhibitor = getItem(position).getExhibitor();

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.cell_agenda, parent, false);

            tempViewHolder = new ViewHolder();
            tempViewHolder.mNameTextView = (RobotoCondensedBoldTextView) convertView.findViewById(R.id.cell_agenda_name_textview);
            tempViewHolder.mClickView = convertView.findViewById(R.id.cell_agenda_clickview);
            tempViewHolder.mSaloonView = convertView.findViewById(R.id.cell_agenda_saloonview);

            convertView.setTag(tempViewHolder);
        } else
            tempViewHolder = (ViewHolder) convertView.getTag();


        tempViewHolder.mNameTextView.setText(tempExhibitor.getName());
        tempViewHolder.mSaloonView.setBackgroundDrawable(getSaloonColor(getItem(position)));
        tempViewHolder.mClickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener == null)
                    return;

                mListener.onExhibitorClick(tempExhibitor);
            }
        });

        return convertView;
    }

    private ColorDrawable getSaloonColor(Agenda agenda) {
        Category tempCategory = Category.getInstance(agenda.getExhibitor());
        int tempColor = getContext().getResources().getColor(tempCategory.getColorResouce());
        return new ColorDrawable(tempColor);
    }

    public void setOnExhibitorClickListener(OnExhibitorClickListener callback) {
        this.mListener = callback;
    }

    private static class ViewHolder {
        RobotoCondensedBoldTextView mNameTextView;
        View mClickView;
        View mSaloonView;
    }
}
