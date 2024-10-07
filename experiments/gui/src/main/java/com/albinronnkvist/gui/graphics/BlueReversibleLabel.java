package com.albinronnkvist.gui.graphics;

import javax.swing.*;
import java.awt.Color;

public class BlueReversibleLabel extends JLabel {
    public BlueReversibleLabel(String text) {
        super(text);
        setForeground(Color.BLUE);
    }

    public void reverse() {
        StringBuffer text = new StringBuffer(getText());
        text.reverse();
        setText(text.toString());
    }

    @Override
    public void setForeground(Color color) {
        super.setForeground(Color.BLUE);
    }
}
