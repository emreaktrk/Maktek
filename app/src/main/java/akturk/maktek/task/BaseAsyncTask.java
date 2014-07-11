package akturk.maktek.task;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import akturk.maktek.interfaces.ServiceCallback;
import akturk.maktek.util.NetworkUtil;

abstract class BaseAsyncTask<Class> extends AsyncTask<Void, Void, Boolean> {
    private Context mContext;
    private ServiceCallback<ArrayList<Class>> mCallback;
    private ArrayList<Class> mList;

    public BaseAsyncTask(Context context, ServiceCallback<ArrayList<Class>> callback) {
        this.mContext = context;
        this.mCallback = callback;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        if (!NetworkUtil.isOnline(mContext))
            return null;

        mCallback.onProgress();
        mList = getListFromService();

        if (mList != null && mList.size() > 0)
            return true;

        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);

        if (result == null)
            mCallback.onOffline();
        else if (result)
            mCallback.onSuccess(mList);
        else
            mCallback.onFailure();
    }

    public ArrayList<Class> getList() {
        return mList;
    }

    public abstract ArrayList<Class> getListFromService();
}
