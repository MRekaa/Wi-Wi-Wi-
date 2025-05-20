package org.garden.database;
import org.garden.model.PlantTypeFactory;

import org.garden.model.Garden;
import org.garden.model.Plant;
import org.garden.model.PlantType;

import java.sql.*;

public class GardenRepository {


    // Lekéri az eddigi legnagyobb garden id-t (ha nincs, akkor 0-t ad vissza)
    public int getMaxGardenId() throws SQLException {
        String sql = "SELECT MAX(id) AS max_id FROM gardens";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("max_id");
            }
        }
        return 0;
    }

    // Mentés új kertként vagy frissítésként, a meglévő id alapján
    public int saveGarden(Garden garden, String name, int existingId) throws SQLException {
        String sql;
        int gardenId = existingId;

        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false);

            if (gardenId <= 0) {
                // új kert beszúrása - kézzel generált id-vel
                gardenId = getMaxGardenId() + 1;
                sql = "INSERT INTO gardens (id, name, rowss, cols) VALUES (?, ?, ?, ?)";
            } else {
                // meglévő kert frissítése
                sql = "UPDATE gardens SET name = ?, rowss = ?, cols = ? WHERE id = ?";
            }

            try (PreparedStatement gardenStmt = conn.prepareStatement(sql)) {
                if (existingId <= 0) {
                    gardenStmt.setInt(1, gardenId);
                    gardenStmt.setString(2, name);
                    gardenStmt.setInt(3, garden.getRows());
                    gardenStmt.setInt(4, garden.getCols());
                } else {
                    gardenStmt.setString(1, name);
                    gardenStmt.setInt(2, garden.getRows());
                    gardenStmt.setInt(3, garden.getCols());
                    gardenStmt.setInt(4, gardenId);
                }
                gardenStmt.executeUpdate();

                // Ha frissítünk, töröljük a régi növényeket, mert újat mentünk majd
                if (existingId > 0) {
                    try (PreparedStatement deletePlantsStmt = conn.prepareStatement("DELETE FROM plants WHERE garden_id = ?")) {
                        deletePlantsStmt.setInt(1, gardenId);
                        deletePlantsStmt.executeUpdate();
                    }
                }

                // Új növények beszúrása
                String insertPlantSQL = "INSERT INTO plants (garden_id, row_pos, col_pos, type) VALUES (?, ?, ?, ?)";
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

    // Betölt egy kertet az adatbázisból az ID alapján
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
                garden.setId(gardenId);
            }

            try (PreparedStatement plantStmt = conn.prepareStatement(getPlantsSQL)) {
                plantStmt.setInt(1, gardenId);
                ResultSet rs = plantStmt.executeQuery();
                while (rs.next()) {
                    int row = rs.getInt("row_pos");
                    int col = rs.getInt("col_pos");
                    String typeName = rs.getString("type");

                    PlantType plantType = PlantTypeFactory.getPlantType(typeName);
                    if (plantType != null) {
                        garden.placePlant(row, col, new Plant(plantType, row, col));
                    } else {
                        // Ha nem található a típus, kezelheted itt hibaüzenettel vagy alapértelmezettel
                        System.err.println("Ismeretlen növénytípus az adatbázisban: " + typeName);
                    }
                }
            }

            return garden;
        }
    }

    // Új metódus: ellenőrzi, hogy adott pozíción van-e növény az adatbázisban
    public boolean isPositionOccupied(int gardenId, int row, int col) throws SQLException {
        String sql = "SELECT COUNT(*) FROM plants WHERE garden_id = ? AND row_pos = ? AND col_pos = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, gardenId);
            stmt.setInt(2, row);
            stmt.setInt(3, col);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    // Új metódus: növény elhelyezése az adatbázisban, hibát dob, ha a hely már foglalt
    public void placePlantWithCheck(int gardenId, int row, int col, Plant plant) throws SQLException {
        if (isPositionOccupied(gardenId, row, col)) {
            throw new IllegalStateException("Az adott pozíción már van növény az adatbázisban: (" + row + ", " + col + ")");
        }

        String sql = "INSERT INTO plants (garden_id, row_pos, col_pos, type) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, gardenId);
            stmt.setInt(2, row);
            stmt.setInt(3, col);
            stmt.setString(4, plant.getType().getName());
            stmt.executeUpdate();
        }
    }
}
