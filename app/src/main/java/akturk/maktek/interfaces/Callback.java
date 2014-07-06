package akturk.maktek.interfaces;


public interface Callback<T> {
    public void onProgress();

    public void onSuccess(T result);

    public void onFailure();
}
