package org.garden.model;

public class Garden {
    private final int rows;
    private final int cols;
    private final Plant[][] plants;

    public Garden(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.plants = new Plant[rows][cols];
    }

    public int getRows() {return rows;}
    public int getCols() {return cols;}

    public void placePlant(int row, int col, Plant plant) {
        plants[row][col] = plant;
    }
    public Plant getPlant(int row, int col) {
        return plants[row][col];
    }
    public void removePlant(int row, int col) {
        plants[row][col] = null;
    }
}
