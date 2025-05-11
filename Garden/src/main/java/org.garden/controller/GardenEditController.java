package org.garden.controller;

import org.garden.database.GardenRepository;
import org.garden.model.Garden;
import org.garden.model.Plant;
import org.garden.model.PlantType;
import org.garden.view.GardenEditorView;

import javax.swing.*;
import java.sql.SQLException;

public class GardenEditController {
    private final Garden garden;
    private final GardenEditorView view;

    public GardenEditController(Garden garden) {
        this.garden = garden;
        this.view = new GardenEditorView(garden.getRows(), garden.getCols());

        initListeners();
    }

    private void initListeners() {
        for (int i = 0; i < garden.getRows(); i++) {
            for (int j = 0; j < garden.getCols(); j++) {
                final int row = i;
                final int col = j;

                view.addGridButtonListener(row, col, e -> {
                    PlantDialogController dialog = new PlantDialogController();
                    PlantType selectedType = dialog.showPlantSelectionDialog(view);

                    if (selectedType != null) {
                        Plant plant = new Plant(selectedType, row, col);
                        garden.placePlant(row, col, plant);
                        view.getGridButton(row, col).setText(selectedType.getName());
                    }
                });
            }
        }

        view.addSaveButtonListener(e -> {
            GardenRepository repo = new GardenRepository();
            try {
                repo.saveGarden(garden, "TesztKert");
                JOptionPane.showMessageDialog(view, "Mentés sikeres!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "Mentés sikertelen: " + ex.getMessage());
            }
        });

        view.addBackButtonListener(e -> {
            view.dispose();
            new MainController(); // visszalépés főmenübe
        });
    }
}
