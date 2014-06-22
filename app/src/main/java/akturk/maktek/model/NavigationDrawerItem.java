package akturk.maktek.model;

import android.graphics.drawable.Drawable;

public final class NavigationDrawerItem {
    private Drawable mIconDrawable;
    private CharSequence mLabel;

    public NavigationDrawerItem(Drawable mIconDrawable, CharSequence mLabel) {
        this.mIconDrawable = mIconDrawable;
        this.mLabel = mLabel;
    }

    public NavigationDrawerItem() {
        this.mIconDrawable = null;
        this.mLabel = "";
    }

    public void setLabel(CharSequence label) {
        this.mLabel = label;
    }

    public CharSequence getLabel() {
        return mLabel;
    }


    public Drawable getIconDrawable() {
        return mIconDrawable;
    }

    public void setIconDrawable(Drawable icon) {
        this.mIconDrawable = icon;
    }
}
