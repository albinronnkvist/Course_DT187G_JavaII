package com.albinronnkvist.gui.components.layouts;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import com.albinronnkvist.gui.components.CustomFrame;

public class CustomFlowLayoutFrame extends CustomFrame {
    public CustomFlowLayoutFrame() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 40));

        var redPanel = createColoredPanel(Color.RED, 100, 100);
        var greenPanel = createColoredPanel(Color.GREEN, 100, 100);
        var bluePanel = createColoredPanel(Color.BLUE, 100, 100);
        var yellowPanel = createColoredPanel(Color.YELLOW, 100, 100);
        var orangePanel = createColoredPanel(Color.ORANGE, 100, 100);

        this.add(redPanel);
        this.add(greenPanel);
        this.add(bluePanel);
        this.add(yellowPanel);
        this.add(orangePanel);

        this.setVisible(true);
    }

    // Helper method to create a JPanel with a specific color and size
    private JPanel createColoredPanel(Color color, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setPreferredSize(new java.awt.Dimension(width, height));
        return panel;
    }
}
