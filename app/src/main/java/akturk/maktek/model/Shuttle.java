package akturk.maktek.model;


public final class Shuttle {
    private String mName;
    private String mDescription;
    private String mDeparture;
    private String mReturn;

    public Shuttle(String name, String description, String departure, String rturn) {
        this.mName = name;
        this.mDescription = description;
        this.mDeparture = departure;
        this.mReturn = rturn;
    }

    public Shuttle() {
        mName = "";
        mDescription = "";
        mDeparture = "";
        mReturn = "";
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDeparture() {
        return mDeparture;
    }

    public void setDeparture(String departure) {
        this.mDeparture = departure;
    }

    public String getReturn() {
        return mReturn;
    }

    public void setReturn(String rturn) {
        this.mReturn = rturn;
    }
}
