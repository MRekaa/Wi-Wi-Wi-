package org.garden.model;

public class PlantType {
    private final String name;
    private final String lightRequirement;
    private final String waterRequirement;
    private final String soilRequirement;

    public PlantType(String name) {
        this.name = name;

        // Egyszerű példa: keménykódolt igények típustól függően
        switch (name.toLowerCase()) {
            case "rose" -> {
                lightRequirement = "Sok fény";
                waterRequirement = "Közepes vízigény";
                soilRequirement = "Semleges talaj";
            }
            case "sunflower" -> {
                lightRequirement = "Teljes napfény";
                waterRequirement = "Magas vízigény";
                soilRequirement = "Laza, tápdús talaj";
            }
            case "tulip" -> {
                lightRequirement = "Félárnyék";
                waterRequirement = "Alacsony vízigény";
                soilRequirement = "Homokos talaj";
            }
            default -> {
                lightRequirement = "Ismeretlen";
                waterRequirement = "Ismeretlen";
                soilRequirement = "Ismeretlen";
            }
        }
    }

    public String getName() { return name;}
    public String getLightRequirement() {return lightRequirement;}
    public String getWaterRequirement() {return waterRequirement;}
    public String getSoilRequirement() {return soilRequirement;}
}
