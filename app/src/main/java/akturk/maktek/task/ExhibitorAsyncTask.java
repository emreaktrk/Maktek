package akturk.maktek.task;

import android.content.Context;

import java.util.ArrayList;

import akturk.maktek.interfaces.ServiceCallback;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.ServiceDataProvider;

public final class ExhibitorAsyncTask extends BaseAsyncTask<Exhibitor> {

    public ExhibitorAsyncTask(Context context, ServiceCallback<ArrayList<Exhibitor>> callback) {
        super(context, callback);
    }

    @Override
    public ArrayList getListFromService() {
        return ServiceDataProvider.getListOfExhibitors();
    }

}
