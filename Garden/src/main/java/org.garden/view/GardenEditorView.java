package org.garden.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GardenEditorView extends JFrame {
    private final JButton[][] gridButtons;
    private final JPanel gridPanel;
    private final JButton saveButton = new JButton("Mentés");
    private final JButton backButton = new JButton("Vissza");

    public GardenEditorView(int rows, int cols) {
        setTitle("Kert szerkesztése");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gridPanel = new JPanel(new GridLayout(rows, cols));
        gridButtons = new JButton[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(50, 50));
                gridButtons[i][j] = btn;
                gridPanel.add(btn);
            }

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.add(saveButton);
        controlPanel.add(backButton);

        add(gridPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getGridButton(int row, int col) {
        return gridButtons[row][col];
    }

    public void addGridButtonListener(int row, int col, ActionListener listener) {
        gridButtons[row][col].addActionListener(listener);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
