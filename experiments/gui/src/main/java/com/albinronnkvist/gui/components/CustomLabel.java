package com.albinronnkvist.gui.components;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class CustomLabel extends JLabel {
    public CustomLabel() {
        this.setText("This is a label");
        
        this.setForeground(Color.BLACK);
        this.setFont(new Font("SansSerif", Font.PLAIN, 16));

        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);

        var labelIcon = new ImageIcon(getClass().getResource("/logo.png"));
        this.setIcon(labelIcon);
        this.setIconTextGap(10);

        this.setHorizontalTextPosition(JLabel.RIGHT);
        this.setVerticalTextPosition(JLabel.CENTER);

    }
}
