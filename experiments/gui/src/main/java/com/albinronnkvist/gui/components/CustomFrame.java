package com.albinronnkvist.gui.components;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CustomFrame extends JFrame {
    public CustomFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Albin's Program");
        this.getContentPane().setBackground(Color.lightGray);
        
        this.setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
    }
}
