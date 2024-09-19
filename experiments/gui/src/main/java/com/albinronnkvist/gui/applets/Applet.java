package com.albinronnkvist.gui.applets;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JApplet;
import javax.swing.JLabel;

@SuppressWarnings("removal")
public class Applet extends JApplet {
    // Called once when the applet is first loaded.
    @Override
    public void init() {
        var label1 = new JLabel("Welcome", JLabel.CENTER);

        add(label1);

        label1.setOpaque(true);
        label1.setBackground(Color.yellow);
        label1.setForeground(Color.blue);
        label1.setFont(new Font("SansSerif", Font.BOLD, 24));
    }
}
