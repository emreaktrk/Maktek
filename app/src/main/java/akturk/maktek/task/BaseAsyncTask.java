package akturk.maktek.task;

import android.os.AsyncTask;

import java.util.ArrayList;

import akturk.maktek.interfaces.Callback;

abstract class BaseAsyncTask<Class> extends AsyncTask<Void, Void, Boolean> {
    private Callback<ArrayList<Class>> mCallback;
    private ArrayList<Class> mList;

    public BaseAsyncTask(Callback<ArrayList<Class>> callback) {
        this.mCallback = callback;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        mCallback.onProgress();
        mList = getListFromService();

        if (mList != null && mList.size() > 0)
            return true;

        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        if (result)
            mCallback.onSuccess(mList);
        else
            mCallback.onFailure();
    }

    public ArrayList<Class> getList() {
        return mList;
    }

    public abstract ArrayList<Class> getListFromService();
}
