package akturk.maktek.model;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import akturk.maktek.R;
import akturk.maktek.constant.Saloons;

public enum Category {
    MACHINE_TOOLS(R.string.category_machine_tools, Saloons.MACHINE_TOOLS, R.color.saloon_machine_tools),
    METAL_PROCESSING_TECHNOLOGIES(R.string.category_metal_processing_technologies, Saloons.METAL_PROCESSING_TECHNOLOGIES, R.color.saloon_metal_processing_technologies),
    TOOLS(R.string.category_tools, Saloons.TOOLS, R.color.saloon_tools),
    METROLOGY_MEASUREMENT_QUALITY_CONTROL_AND_TEST_EQUIPMENT(R.string.category_metrology_and_measurement, Saloons.METROLOGY_MEASUREMENT_QUALITY_CONTROL_AND_TEST_EQUIPMENT, R.color.saloon_metrology_and_measurement),
    INTERNATIONAL_PARTICIPATIONS_AND_OTHER(R.string.category_international_participations_and_other, Saloons.INTERNATIONAL_PARTICIPATIONS_AND_OTHER, R.color.saloon_international_participations_and_other),
    CADCAM_AND_CONTROL_SYSTEMS(R.string.category_cadcam_and_control_systems, Saloons.CADCAM_AND_CONTROL_SYSTEMS, R.color.saloon_cadcam_and_control_systems),
    OTHERS(R.string.category_others, Saloons.OTHERS, R.color.saloon_others),
    ALL(R.string.category_all, Saloons.ALL, android.R.color.darker_gray);

    @StringRes
    private int mNameResource;
    private String[] mSaloons;
    @ColorRes
    private int mColorResouce;


    public static Category getInstance(Exhibitor exhibitor) {
        for (Category tempCategory : Category.values())
            for (String tempSaloon : tempCategory.getSaloons())
                if (TextUtils.equals(tempSaloon, exhibitor.getSaloonNo()))
                    return tempCategory;

        throw new IllegalArgumentException("Unknown saloon.");
    }

    public static Category getInstance(int position) {
        for (Category tempCategory : Category.values())
            if (tempCategory.ordinal() == position)
                return tempCategory;

        throw new IllegalArgumentException("Unknown saloon.");
    }

    public static Category getInstance(Context context, String name) {
        for (Category tempCategory : Category.values())
            if (TextUtils.equals(name, tempCategory.getName(context)))
                return tempCategory;

        throw new IllegalArgumentException("Unknown saloon.");
    }

    private Category(int nameResource, String[] saloons, int colorResouce) {
        this.mNameResource = nameResource;
        this.mSaloons = saloons;
        this.mColorResouce = colorResouce;
    }

    public String getName(Context context) {
        return context.getString(mNameResource);
    }

    public String[] getSaloons() {
        return mSaloons;
    }

    public int getColorResouce() {
        return mColorResouce;
    }
}
