package akturk.maktek.provider;

import android.content.Context;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import akturk.maktek.model.IOObject;

abstract class BaseDataProvider<T extends IOObject> {
    private ArrayList<T> mList;
    private Context mContext;

    protected BaseDataProvider(Context context) {
        this.mContext = context;
    }

    public final void add(T object) {
        mList.add(object);
    }

    public final void remove(T object) {
        mList.remove(object);
    }

    public final int size() {
        if (mList == null)
            return -1;

        return mList.size();
    }

    public final boolean contains(T object) {
        return mList.contains(object);
    }

    public final boolean save() {
        return new AsyncSave().write();
    }

    protected abstract String getName();

    private final String getFileName() {
        return "/" + getName() + ".bin";
    }

    private final class AsyncSave extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            String tempPath = mContext.getFilesDir() + getFileName();
            try {
                ObjectOutputStream tempOutputStream = new ObjectOutputStream(new FileOutputStream(new File(tempPath)));
                tempOutputStream.writeObject(mList);
                tempOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        private final boolean write() {
            try {
                execute();
                return true;
            } catch (Exception exception) {
                return false;
            }
        }
    }
}
