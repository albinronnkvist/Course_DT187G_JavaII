package com.albinronnkvist.gui.components.layouts;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import com.albinronnkvist.gui.components.CustomFrame;

public class CustomGridLayoutFrame extends CustomFrame {
    public CustomGridLayoutFrame() {
        // Set GridLayout with 2 rows and 3 columns, and 10px horizontal and vertical gaps
        this.setLayout(new GridLayout(2, 3, 10, 10));

        JPanel redPanel = createColoredPanel(Color.RED);
        JPanel greenPanel = createColoredPanel(Color.GREEN);
        JPanel bluePanel = createColoredPanel(Color.BLUE);
        JPanel yellowPanel = createColoredPanel(Color.YELLOW);
        JPanel orangePanel = createColoredPanel(Color.ORANGE);
        JPanel pinkPanel = createColoredPanel(Color.PINK);

        this.add(redPanel);
        this.add(greenPanel);
        this.add(bluePanel);
        this.add(yellowPanel);
        this.add(orangePanel);
        this.add(pinkPanel);

        this.setVisible(true);
    }

    private JPanel createColoredPanel(Color color) {
        var panel = new JPanel();
        panel.setBackground(color);
        return panel;
    }
}