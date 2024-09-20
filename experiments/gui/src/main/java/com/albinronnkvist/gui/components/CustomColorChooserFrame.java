package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomColorChooserFrame extends CustomFrame implements ActionListener {
    private JButton button;
    private JPanel colorPanel;

    public CustomColorChooserFrame() {
        button = new JButton("Choose Color");
        button.addActionListener(this);

        colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(200, 200));
        colorPanel.setBackground(Color.WHITE);

        var mainPanel = new JPanel();
        mainPanel.add(button);
        mainPanel.add(colorPanel);

        this.add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            Color selectedColor = JColorChooser.showDialog(this, "Choose a Color", colorPanel.getBackground());
            
            if (selectedColor != null) {
                colorPanel.setBackground(selectedColor);
            }
        }
    }
}
