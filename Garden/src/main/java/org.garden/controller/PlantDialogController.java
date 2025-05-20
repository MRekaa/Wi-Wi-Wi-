package org.garden.controller;

import org.garden.model.PlantType;
import org.garden.model.PlantTypeFactory;

import javax.swing.*;

public class PlantDialogController {
    public PlantType showPlantSelectionDialog(JFrame parent) {
        String[] plantOptions = PlantTypeFactory.getAvailablePlantNames();

        String selection = (String) JOptionPane.showInputDialog(
                parent,
                "Válassz egy növényt:",
                "Növény kiválasztása",
                JOptionPane.PLAIN_MESSAGE,
                null,
                plantOptions,
                plantOptions[0]
        );

        if (selection != null) {
            return PlantTypeFactory.getPlantType(selection);
        }

        return null; // A felhasználó kilépett
    }
}
