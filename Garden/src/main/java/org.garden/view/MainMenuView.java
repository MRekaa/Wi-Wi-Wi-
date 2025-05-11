package org.garden.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {
    private final JButton newGardenButton = new JButton("Új kert");
    private final JButton loadGardenButton = new JButton("Kert betöltése");
    private final JButton exitButton = new JButton("Kilépés");

    public MainMenuView() {
        setTitle("Garden Planner - Főmenü");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.add(newGardenButton);
        panel.add(loadGardenButton);
        panel.add(exitButton);
        add(panel);
        setVisible(true);
    }

    public void addNewGardenListener(ActionListener listener) {
        newGardenButton.addActionListener(listener);
    }

    public void addLoadGardenListener(ActionListener listener) {
        loadGardenButton.addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
