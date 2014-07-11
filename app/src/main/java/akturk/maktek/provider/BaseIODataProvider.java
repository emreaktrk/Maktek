package akturk.maktek.provider;

import android.content.Context;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import akturk.maktek.interfaces.OnIODataListener;
import akturk.maktek.model.IOObject;

abstract class BaseIODataProvider<T extends IOObject> {
    private Context mContext;
    private OnIODataListener mListener;

    protected BaseIODataProvider(Context context) {
        this.mContext = context;
    }

    public final boolean save(ArrayList<T> list) {
        return new AsyncSave(list).write();
    }

    public final ArrayList<T> read() {
        ArrayList<T> tempList = new ArrayList<T>();
        String tempPath = mContext.getFilesDir() + getFileName();
        try {
            File tempFile = new File(tempPath);
            FileInputStream tempFileInputStream = new FileInputStream(tempFile);
            ObjectInputStream tempObjectInputStream = new ObjectInputStream(tempFileInputStream);
            tempList = (ArrayList<T>) tempObjectInputStream.readObject();
            tempFileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tempList;
    }

    protected abstract String getName();

    private final String getFileName() {
        return "/" + getName() + ".bin";
    }

    protected final void setOnIODataListener(OnIODataListener callback) {
        this.mListener = callback;
    }

    private final class AsyncSave extends AsyncTask<Void, Void, Boolean> {
        private ArrayList<T> mList;

        private AsyncSave(ArrayList<T> list) {
            this.mList = list;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            String tempPath = mContext.getFilesDir() + getFileName();
            try {
                File tempFile = new File(tempPath);
                FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
                ObjectOutputStream tempOutputStream = new ObjectOutputStream(tempFileOutputStream);
                tempOutputStream.writeObject(mList);
                tempOutputStream.flush();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            if (mListener == null)
                return;

            if (result)
                mListener.onDataSaveSuccess();
            else
                mListener.onDataSaveFailure();
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
