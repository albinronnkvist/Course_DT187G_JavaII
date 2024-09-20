package com.albinronnkvist.gui.components;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;

public class CustomPanel extends JPanel {
    public CustomPanel(Color color, int x, int y) {
        this.setBackground(color);
        this.setBounds(x, y, 250, 250);
        this.setLayout(new BorderLayout());
    }
}
