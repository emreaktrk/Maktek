package akturk.maktek.constant;

public enum Categories {
    MACHINE_TOOLS("MACHINE TOOLS", Saloons.MACHINE_TOOLS),
    METAL_PROCESSING_TECHNOLOGIES("METAL PROCESSING TECHNOLOGIES", Saloons.METAL_PROCESSING_TECHNOLOGIES),
    TOOLS("TOOLS", Saloons.TOOLS),
    METROLOGY_AND_MEASUREMENT("METROLOGY AND MEASUREMENT", Saloons.METROLOGY_AND_MEASUREMENT),
    QUALITY_CONTROL_AND_TEST_EQUIPMENT("QUALITY CONTROL AND TEST EQUIPMENT", Saloons.QUALITY_CONTROL_AND_TEST_EQUIPMENT),
    INTERNATIONAL_PARTICIPATIONS_AND_OTHER("INTERNATIONAL PARTICIPATIONS AND OTHER", Saloons.INTERNATIONAL_PARTICIPATIONS_AND_OTHER),
    CADCAM_AND_CONTROL_SYSTEMS("CADCAM AND CONTROL SYSTEMS", Saloons.CADCAM_AND_CONTROL_SYSTEMS),
    OTHERS("OTHERS", Saloons.OTHERS);

    private String mName;
    private String[] mSaloons;

    private Categories(String name, String[] saloons) {
        this.mName = name;
        this.mSaloons = mSaloons;
    }

    public String getName() {
        return mName;
    }

    public String[] getSaloons() {
        return mSaloons;
    }
}
