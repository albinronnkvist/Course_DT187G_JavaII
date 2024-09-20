package com.albinronnkvist.gui.components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class CustomLayeredPaneFrame extends CustomFrame {
    public CustomLayeredPaneFrame() {
        var layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 400));

        var redPanel = createColoredPanel(Color.RED, 200, 200, 50, 50);
        var greenPanel = createColoredPanel(Color.GREEN, 150, 150, 100, 100);
        var bluePanel = createColoredPanel(Color.BLUE, 100, 100, 150, 150);

        layeredPane.add(redPanel, JLayeredPane.DEFAULT_LAYER); // Can also do Integer.valueOf(n)
        layeredPane.add(greenPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(bluePanel, JLayeredPane.MODAL_LAYER);

        this.add(layeredPane);
        this.pack();
        this.setVisible(true);
    }

    private JPanel createColoredPanel(Color color, int width, int height, int x, int y) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        return panel;
    }
}