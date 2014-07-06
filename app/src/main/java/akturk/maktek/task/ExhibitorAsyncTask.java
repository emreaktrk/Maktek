package akturk.maktek.task;

import java.util.ArrayList;

import akturk.maktek.interfaces.Callback;
import akturk.maktek.model.Exhibitor;
import akturk.maktek.provider.ServiceDataProvider;

public final class ExhibitorAsyncTask extends BaseAsyncTask<Exhibitor> {


    public ExhibitorAsyncTask(Callback callback) {
        super(callback);
    }

    @Override
    public ArrayList getListFromService() {
        return ServiceDataProvider.getListOfExhibitors();
    }
}
