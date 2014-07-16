package akturk.maktek.model;

public final class Office {
    String mName;
    String mTitle;
    String mAdress;
    String mContact;
    String mPhone;
    String mFax;
    String mWebsite;
    String mEmail;

    public Office(String name, String title, String adress, String contact, String phone, String fax, String website, String email) {
        mName = name;
        mTitle = title;
        mAdress = adress;
        mContact = contact;
        mPhone = phone;
        mFax = fax;
        mWebsite = website;
        mEmail = email;
    }

    public Office() {
        mName = "";
        mTitle = "";
        mAdress = "";
        mContact = "";
        mPhone = "";
        mFax = "";
        mWebsite = "";
        mEmail = "";
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContact() {
        return mContact;
    }

    public void setContact(String contact) {
        this.mContact = contact;
    }

    public String getAdress() {
        return mAdress;
    }

    public void setAdress(String adress) {
        this.mAdress = adress;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        this.mPhone = phone;
    }

    public String getFax() {
        return mFax;
    }

    public void setFax(String fax) {
        this.mFax = fax;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }
}
