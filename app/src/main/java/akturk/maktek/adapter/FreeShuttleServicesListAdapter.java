package akturk.maktek.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import akturk.maktek.model.Shuttle;


public class FreeShuttleServicesListAdapter extends ArrayAdapter<Shuttle> {

    public FreeShuttleServicesListAdapter(Context context, List<Shuttle> objects) {
        super(context, 0, objects);
    }
}
