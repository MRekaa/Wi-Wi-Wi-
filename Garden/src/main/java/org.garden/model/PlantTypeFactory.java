package org.garden.model;

import java.util.HashMap;
import java.util.Map;

public class PlantTypeFactory {
    private static final Map<String, PlantType> plantTypes = new HashMap<>();

    static {
        plantTypes.put("Rose", new PlantType("Rose", new CareInstruction("Napfény", "Közepes", "Humuszos")));
        plantTypes.put("Sunflower", new PlantType("Sunflower", new CareInstruction("Teljes napfény", "Magas", "Laza")));
        plantTypes.put("Tulip", new PlantType("Tulip", new CareInstruction("Félárnyék", "Alacsony", "Homokos")));
        plantTypes.put("Cactus", new PlantType("Cactus", new CareInstruction("Napos hely", "Nagyon alacsony", "Kaktuszföld")));

    }

    public static PlantType getPlantType(String name) {
        return plantTypes.get(name);
    }

    public static String[] getAvailablePlantNames() {
        return plantTypes.keySet().toArray(new String[0]);
    }
}
