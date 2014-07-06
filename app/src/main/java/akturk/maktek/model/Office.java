package akturk.maktek.model;

public final class Office {
    String mName;
    String mAdress;
    String mContact;
    String mPhone;
    String mFax;
    String mEmail;

    public Office(String name, String contact, String adress, String phone, String fax, String email) {
        this.mName = name;
        this.mContact = contact;
        this.mAdress = adress;
        this.mPhone = phone;
        this.mFax = fax;
        this.mEmail = email;
    }

    public Office() {
        this.mName = "";
        this.mContact = "";
        this.mAdress = "";
        this.mPhone = "";
        this.mFax = "";
        this.mEmail = "";
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
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

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }
}
