package akturk.maktek.provider;

import android.content.Context;

import java.util.ArrayList;

import akturk.maktek.model.Agenda;
import akturk.maktek.model.Exhibitor;

public final class AgendaIODataProvider extends BaseIODataProvider<Agenda> {
    private ArrayList<Agenda> mList;

    public AgendaIODataProvider(Context context) {
        super(context);
    }

    @Override
    protected String getName() {
        return Agenda.class.getName();
    }

    public final ArrayList<Agenda> getList() {
        if (mList == null)
            mList = read();

        return mList;
    }

    public final void add(Agenda agenda) {
        getList().add(agenda);
    }

    public final void remove(Agenda agenda) {
        getList().remove(agenda);
    }

    public final boolean contains(Agenda agenda) {
        return getList().contains(agenda);
    }

    public final boolean contains(Exhibitor exhibitor) {
        for (Agenda tempAgenda : getList())
            if (tempAgenda.getExhibitor().equals(exhibitor))
                return true;

        return false;
    }
}
