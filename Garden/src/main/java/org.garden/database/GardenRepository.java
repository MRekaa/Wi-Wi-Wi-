package org.garden.database;

import org.garden.model.Garden;
import org.garden.model.Plant;

import java.sql.*;

public class GardenRepository {
    public int saveGarden(Garden garden, String name) throws SQLException {
        String insertGardenSQL = "INSERT INTO gardens (name, rowss, cols) VALUES (?, ?, ?)";
        String insertPlantSQL = "INSERT INTO plants (garden_id, row_pos, col_pos, type) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement gardenStmt = conn.prepareStatement(insertGardenSQL, Statement.RETURN_GENERATED_KEYS)) {
                gardenStmt.setString(1, name);
                gardenStmt.setInt(2, garden.getRows());
                gardenStmt.setInt(3, garden.getCols());
                gardenStmt.executeUpdate();

                ResultSet keys = gardenStmt.getGeneratedKeys();
                keys.next();
                int gardenId = keys.getInt(1);

                try (PreparedStatement plantStmt = conn.prepareStatement(insertPlantSQL)) {
                    for (int i = 0; i < garden.getRows(); i++) {
                        for (int j = 0; j < garden.getCols(); j++) {
                            Plant plant = garden.getPlant(i, j);
                            if (plant != null) {
                                plantStmt.setInt(1, gardenId);
                                plantStmt.setInt(2, i);
                                plantStmt.setInt(3, j);
                                plantStmt.setString(4, plant.getType().getName());
                                plantStmt.addBatch();
                            }
                        }
                    }
                    plantStmt.executeBatch();
                }

                conn.commit();
                return gardenId;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    public Garden loadGarden(int gardenId) throws SQLException {
        String getGardenSQL = "SELECT * FROM gardens WHERE id = ?";
        String getPlantsSQL = "SELECT * FROM plants WHERE garden_id = ?";

        try (Connection conn = DatabaseManager.getConnection()) {
            Garden garden;

            try (PreparedStatement gardenStmt = conn.prepareStatement(getGardenSQL)) {
                gardenStmt.setInt(1, gardenId);
                ResultSet rs = gardenStmt.executeQuery();
                if (!rs.next()) return null;

                int rows = rs.getInt("rowss");
                int cols = rs.getInt("cols");
                garden = new Garden(rows, cols);
            }

            try (PreparedStatement plantStmt = conn.prepareStatement(getPlantsSQL)) {
                plantStmt.setInt(1, gardenId);
                ResultSet rs = plantStmt.executeQuery();
                while (rs.next()) {
                    int row = rs.getInt("row_pos");
                    int col = rs.getInt("col_pos");
                    String type = rs.getString("type");
                    garden.placePlant(row, col, new Plant(new org.garden.model.PlantType(type), row, col));
                }
            }

            return garden;
        }
    }
}
