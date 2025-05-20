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
        for (int row = 0; row < garden.getRows(); row++) {
            for (int col = 0; col < garden.getCols(); col++) {
                JButton cellButton = view.getGridButton(row, col);

                Plant plant = garden.getPlantAt(row, col);
                if (plant != null) {
                    cellButton.setText(plant.getType().getName());
                }

                final int r = row;
                final int c = col;

                // Bal klikk → növény ültetés
                cellButton.addActionListener(e -> {
                    PlantDialogController dialog = new PlantDialogController();
                    PlantType selectedType = dialog.showPlantSelectionDialog(view);

                    if (selectedType != null) {
                        Plant newPlant = new Plant(selectedType, r, c);
                        garden.placePlant(r, c, newPlant);
                        cellButton.setText(selectedType.getName());
                    }
                });

                // Jobb klikk → információ
                cellButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            Plant p = garden.getPlantAt(r, c);
                            if (p != null) {
                                PlantType type = p.getType();
                                String info = "Növény: " + type.getName() + "\n"
                                        + "Fényigény: " + type.getLightRequirement() + "\n"
                                        + "Víz: " + type.getWaterRequirement() + "\n"
                                        + "Talaj: " + type.getSoilRequirement();
                                JOptionPane.showMessageDialog(view, info, "Növény információ", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(view, "Nincs növény ezen a mezőn.");
                            }
                        }
                    }
                });
            }
        }


        view.addSaveButtonListener(e -> {
            GardenRepository repo = new GardenRepository();
            try {
                int gardenId = garden.getId();  // -1 vagy 0, ha új kert
                gardenId = repo.saveGarden(garden, "TesztKert", gardenId);
                garden.setId(gardenId); // frissítés mentés után
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
