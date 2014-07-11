package akturk.maktek.model;

public final class Agenda extends IOObject {

    private Exhibitor mExhibitor;

    public Agenda(Exhibitor exhibitor) {
        this.mExhibitor = exhibitor;
    }

    public Exhibitor getExhibitor() {
        return mExhibitor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agenda agenda = (Agenda) o;

        if (!mExhibitor.equals(agenda.mExhibitor)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mExhibitor.hashCode();
    }
}
