package com.albinronnkvist.gui;

import com.albinronnkvist.gui.components.CustomFrame;
import com.albinronnkvist.gui.components.CustomLabel;
import com.albinronnkvist.gui.components.CustomPanel;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        var frame = new CustomFrame();

        var redPanel = new CustomPanel(Color.RED, 0, 0);
        var redLabel = new CustomLabel();
        redPanel.add(redLabel);
        
        var bluePanel = new CustomPanel(Color.BLUE, 250, 0);
        var blueLabel = new CustomLabel();
        bluePanel.add(blueLabel);
        
        frame.add(redPanel);
        frame.add(bluePanel);
        //frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);
    }
}