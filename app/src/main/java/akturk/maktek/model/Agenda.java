package akturk.maktek.model;

public final class Agenda extends IOObject {

    private Exhibitor mExhibitor;

    public Agenda(Exhibitor exhibitor) {
        this.mExhibitor = exhibitor;
    }

    public Exhibitor getExhibitor() {
        return mExhibitor;
    }
}
