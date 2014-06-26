package akturk.maktek.provider;


import android.os.AsyncTask;

import java.util.ArrayList;

abstract class BaseDataProvider<Class> {
    private ArrayList<Class> mList;

    public final void add(Class object) {
        mList.add(object);
    }

    public final void remove(Class object) {
        mList.remove(object);
    }

    public final int size() {
        if (mList == null)
            return -1;

        return mList.size();
    }

    public final boolean contains(Class object) {
        return mList.contains(object);
    }

    private final class AsyncSave extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            return false;
        }
    }
}
