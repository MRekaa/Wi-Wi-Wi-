package org.garden.model;

public class PlantType {
    private final String name;
    private final CareInstruction care;

    public PlantType(String name, CareInstruction care) {
        this.name = name;
        this.care = care;
    }

    public String getName() {
        return name;
    }

    public String getLightRequirement() {
        return care.getLight();
    }

    public String getWaterRequirement() {
        return care.getWater();
    }

    public String getSoilRequirement() {
        return care.getSoil();
    }

    public CareInstruction getCareInstruction() {
        return care;
    }

    @Override
    public String toString() {
        return name + " (Fény: " + getLightRequirement()
                + ", Víz: " + getWaterRequirement()
                + ", Talaj: " + getSoilRequirement() + ")";
    }
}
