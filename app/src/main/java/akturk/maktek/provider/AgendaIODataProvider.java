package akturk.maktek.provider;

import android.content.Context;

import java.util.ArrayList;

import akturk.maktek.model.Agenda;

public final class AgendaIODataProvider extends BaseIODataProvider<Agenda> {
    private ArrayList<Agenda> mList;

    public AgendaIODataProvider(Context context) {
        super(context);
    }

    @Override
    protected String getName() {
        return Agenda.class.getName();
    }

    public ArrayList<Agenda> getList() {
        if (mList == null)
            mList = read();

        return mList;
    }

    public void add(Agenda agenda) {
        getList().add(agenda);
    }

    public boolean contains(Agenda agenda) {
        return mList.contains(agenda);
    }
}
