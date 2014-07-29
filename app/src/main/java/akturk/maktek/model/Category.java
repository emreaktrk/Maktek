package akturk.maktek.model;

import android.text.TextUtils;

import akturk.maktek.R;
import akturk.maktek.constant.Saloons;

public enum Category {
    MACHINE_TOOLS("MACHINE TOOLS", Saloons.MACHINE_TOOLS, R.color.saloon_machine_tools),
    METAL_PROCESSING_TECHNOLOGIES("METAL PROCESSING TECHNOLOGIES", Saloons.METAL_PROCESSING_TECHNOLOGIES, R.color.saloon_metal_processing_technologies),
    TOOLS("TOOLS", Saloons.TOOLS, R.color.saloon_tools),
    METROLOGY_AND_MEASUREMENT("METROLOGY AND MEASUREMENT", Saloons.METROLOGY_AND_MEASUREMENT, R.color.saloon_metrology_and_measurement),
    QUALITY_CONTROL_AND_TEST_EQUIPMENT("QUALITY CONTROL AND TEST EQUIPMENT", Saloons.QUALITY_CONTROL_AND_TEST_EQUIPMENT, R.color.saloon_quality_control_and_test_equipment),
    INTERNATIONAL_PARTICIPATIONS_AND_OTHER("INTERNATIONAL PARTICIPATIONS AND OTHER", Saloons.INTERNATIONAL_PARTICIPATIONS_AND_OTHER, R.color.saloon_international_participations_and_other),
    CADCAM_AND_CONTROL_SYSTEMS("CADCAM AND CONTROL SYSTEMS", Saloons.CADCAM_AND_CONTROL_SYSTEMS, R.color.saloon_cadcam_and_control_systems),
    OTHERS("OTHERS", Saloons.OTHERS, R.color.saloon_others),
    ALL("ALL", Saloons.ALL, android.R.color.darker_gray);

    private String mName;
    private String[] mSaloons;
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

    public static Category getInstance(String name) {
        for (Category tempCategory : Category.values())
            if (TextUtils.equals(name, tempCategory.getName()))
                return tempCategory;

        throw new IllegalArgumentException("Unknown saloon.");
    }

    private Category(String name, String[] saloons, int colorResouce) {
        this.mName = name;
        this.mSaloons = saloons;
        this.mColorResouce = colorResouce;
    }

    public String getName() {
        return mName;
    }

    public String[] getSaloons() {
        return mSaloons;
    }

    public int getColorResouce() {
        return mColorResouce;
    }
}
