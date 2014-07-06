package akturk.maktek.provider;

import android.content.Context;

import akturk.maktek.model.Joiner;

public final class JoinerIODataProvider extends BaseIODataProvider<Joiner> {

    public JoinerIODataProvider(Context context) {
        super(context);
    }

    @Override
    protected String getName() {
        return Joiner.class.getName();
    }
}
