package akturk.maktek.global;

import android.app.Application;

import akturk.maktek.helper.TypefaceLoader;
import akturk.maktek.provider.AgendaIODataProvider;
import akturk.maktek.provider.ExhibitorIODataProvider;
import akturk.maktek.task.LockAsyncTask;

public final class MaktekApplication extends Application {
    public static TypefaceLoader mTypefaceLoader;

    private static AgendaIODataProvider mAgendaIODataProvider;
    private static ExhibitorIODataProvider mExhibitorIODataProvider;

    @Override
    public void onCreate() {
        super.onCreate();

        mAgendaIODataProvider = new AgendaIODataProvider(getApplicationContext());
        mExhibitorIODataProvider = new ExhibitorIODataProvider(getBaseContext());

        new LockAsyncTask().execute();
    }

    public static AgendaIODataProvider getAgendaIODataProvider() {
        return mAgendaIODataProvider;
    }

    public static ExhibitorIODataProvider getExhibitorIODataProvider() {
        return mExhibitorIODataProvider;
    }


}
