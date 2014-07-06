package akturk.maktek.provider;

import android.content.Context;

import akturk.maktek.model.Exhibitor;

public final class ExhibitorIODataProvider extends BaseIODataProvider<Exhibitor> {

    public ExhibitorIODataProvider(Context context) {
        super(context);
    }

    @Override
    protected String getName() {
        return Exhibitor.class.getName();
    }
}
