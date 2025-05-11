package org.garden.model;

public class CareInstruction {
    private final String light;
    private final String water;
    private final String soil;

    public CareInstruction(String light, String water, String soil) {
        this.light = light;
        this.water = water;
        this.soil = soil;
    }

    public String getLight() {return light;}
    public String getWater() {return water;}
    public String getSoil() {return soil;}

    @Override
    public String toString() {
        return "Fény: " + light + ", Víz: " + water + ", Talaj: " + soil;
    }
}
