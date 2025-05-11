package org.garden.controller;

import org.garden.database.GardenRepository;
import org.garden.model.Garden;
import org.garden.view.MainMenuView;

import javax.swing.*;

public class MainController {
    private final MainMenuView view;

    public MainController() {
        view = new MainMenuView();

        view.addNewGardenListener(e -> {
            int rows = Integer.parseInt(JOptionPane.showInputDialog("Sorok száma:"));
            int cols = Integer.parseInt(JOptionPane.showInputDialog("Oszlopok száma:"));
            view.dispose();
            new GardenEditController(new Garden(rows,cols));
        });

        view.addLoadGardenListener(e -> {
            String idStr = JOptionPane.showInputDialog("Add meg a kert ID-jét:");
            try {
                int id = Integer.parseInt(idStr);
                Garden garden = new GardenRepository().loadGarden(id);
                if (garden != null) {
                    view.dispose();
                    new GardenEditController(garden);
                } else {
                    JOptionPane.showMessageDialog(view, "Nem található kert ezzel az ID-vel.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Hiba történt: " + ex.getMessage());
            }
        });

        view.addExitListener(e -> System.exit(0));
    }
}
