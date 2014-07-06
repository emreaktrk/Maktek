package akturk.maktek.model;


public final class Hotel {
    private String mName;
    private String mImageName;
    private String mPhone;
    private String mLocation;
    private String mWebsite;
    private String mStar;

    public Hotel() {
        this.mName = "";
        this.mImageName = "";
        this.mStar = "";
    }

    public Hotel(String name, String imageName, String star) {
        this.mName = name;
        this.mImageName = imageName;
        this.mStar = star;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        this.mPhone = phone;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        this.mWebsite = website;
    }

    public String getImageName() {
        return mImageName;
    }

    public void setImageName(String imageName) {
        this.mImageName = imageName;
    }

    public String getStar() {
        return mStar;
    }

    public void setStar(String star) {
        this.mStar = star;
    }
}
