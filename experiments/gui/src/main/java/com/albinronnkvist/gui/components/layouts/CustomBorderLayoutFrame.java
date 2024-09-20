package com.albinronnkvist.gui.components.layouts;

import java.awt.BorderLayout;
import javax.swing.JButton;
import com.albinronnkvist.gui.components.CustomFrame;

public class CustomBorderLayoutFrame extends CustomFrame {
    public CustomBorderLayoutFrame() {
        this.setLayout(new BorderLayout());

        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");
        JButton centerButton = new JButton("Center");

        this.add(northButton, BorderLayout.NORTH);
        this.add(southButton, BorderLayout.SOUTH);
        this.add(eastButton, BorderLayout.EAST);
        this.add(westButton, BorderLayout.WEST);
        this.add(centerButton, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
