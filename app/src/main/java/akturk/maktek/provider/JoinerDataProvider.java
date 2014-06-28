package akturk.maktek.provider;

import android.content.Context;

import akturk.maktek.model.Agenda;
import akturk.maktek.model.Joiner;

public final class JoinerDataProvider extends BaseDataProvider<Agenda> {

    public JoinerDataProvider(Context context) {
        super(context);
    }

    @Override
    protected String getName() {
        return Joiner.class.getName();
    }
}
