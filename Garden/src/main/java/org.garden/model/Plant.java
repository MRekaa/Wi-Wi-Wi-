package org.garden.model;

import java.util.Objects;

public class Plant {
    private final PlantType type;
    private final int row;
    private final int col;

    public Plant(PlantType type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }

    public PlantType getType() { return type;}
    public int getRow() {return row;}
    public int getCol() {return col;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant plant)) return false;
        return Objects.equals(type, plant.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, type);
    }

    @Override
    public String toString() {
        return "Típus: " + type;
    }
}
