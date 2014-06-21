package akturk.maktek.model;

public class NavigationDrawerItem {
    private int mIconResouce;
    private CharSequence mLabel;

    public NavigationDrawerItem(int mIconResouce, CharSequence mLabel) {
        this.mIconResouce = mIconResouce;
        this.mLabel = mLabel;
    }

    public NavigationDrawerItem() {
        this.mIconResouce = 0;
        this.mLabel = "";
    }

    public void setIconResouce(int resouce) {
        this.mIconResouce = resouce;
    }

    public void setLabel(CharSequence label) {
        this.mLabel = label;
    }

    public int getIconResouce() {
        return mIconResouce;
    }

    public CharSequence getLabel() {
        return mLabel;
    }
}
