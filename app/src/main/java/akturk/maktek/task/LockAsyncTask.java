package akturk.maktek.task;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public final class LockAsyncTask extends AsyncTask<Void, String, String> {

    @Override
    protected String doInBackground(Void... params) {
        return getLock();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if (!TextUtils.isEmpty(result) && TextUtils.equals(result, "1"))
            System.exit(0);
    }

    private String getLock() {
        String mResult = "";

        try {
            URL mUrl = new URL("http://salyangoz.com.tr/maktek/check.php");
            URLConnection mConnection = mUrl.openConnection();

            mConnection.setConnectTimeout(5000);
            mConnection.setReadTimeout(5000);

            BufferedReader mInputStream = new BufferedReader(new InputStreamReader(mConnection.getInputStream()));

            mResult = mInputStream.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mResult;
    }
}
