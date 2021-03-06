package akturk.maktek.interfaces;


public interface ServiceCallback<T> {
    /**
     * Runs on async thread.
     */
    public void onProgress();

    /**
     * Runs on UI thread.
     */
    public void onSuccess(T result);

    /**
     * Runs on UI thread.
     */
    public void onFailure();

    /**
     * Runs on UI thread.
     */
    public void onOffline();
}
