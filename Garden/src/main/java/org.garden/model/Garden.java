package org.garden.model;

public class Garden {
    private int id = -1;  // alapból nincs id
    private final int rows;
    private final int cols;
    private final Plant[][] plants;

    public Garden(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        plants = new Plant[rows][cols];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Plant getPlant(int row, int col) {
        return plants[row][col];
    }

    public void placePlant(int row, int col, Plant plant) {
        plants[row][col] = plant;
    }

    public Plant getPlantAt(int row, int col) {
        return plants[row][col];
    }
}
