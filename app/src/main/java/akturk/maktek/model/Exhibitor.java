package akturk.maktek.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Exhibitor extends IOObject {

    @Expose
    @SerializedName("_id")
    private String mID;

    @Expose
    @SerializedName("_katilimci")
    private String mCompany;

    @Expose
    @SerializedName("_adi")
    private String mName;

    @Expose
    @SerializedName("_detay")
    private String mDetail;

    @Expose
    @SerializedName("_telefon")
    private String mPhone;

    @Expose
    @SerializedName("_faks")
    private String mFax;

    @Expose
    @SerializedName("_adres")
    private String mAdress;

    @Expose
    @SerializedName("_email")
    private String mMail;

    @Expose
    @SerializedName("_web")
    private String mWebsite;

    @Expose
    @SerializedName("_longitude")
    private String mLongitude;

    @Expose
    @SerializedName("_latitute")
    private String mLatitude;

    @Expose
    @SerializedName("_salonno")
    private String mSaloonNo;

    @Expose
    @SerializedName("_standno")
    private String mStandNo;

    private transient boolean mFavourite;

    public String getID() {
        return mID;
    }

    public String getCompany() {
        return mCompany;
    }

    public String getName() {
        return mName;
    }

    public String getDetail() {
        return mDetail;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getFax() {
        return mFax;
    }

    public String getAdress() {
        return mAdress;
    }

    public String getMail() {
        return mMail;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public String getSaloonNo() {
        return mSaloonNo;
    }

    public String getStandNo() {
        return mStandNo;
    }

    public boolean isFavourite() {
        return mFavourite;
    }

    public void setFavourite(boolean favourite) {
        this.mFavourite = favourite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exhibitor exhibitor = (Exhibitor) o;

        if (!mID.equals(exhibitor.mID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mID.hashCode();
    }
}
