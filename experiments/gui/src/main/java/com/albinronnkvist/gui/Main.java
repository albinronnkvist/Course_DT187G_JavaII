package com.albinronnkvist.gui;

import com.albinronnkvist.gui.components.CustomFrame;
import com.albinronnkvist.gui.components.CustomLabel;

public class Main {
    public static void main(String[] args) {
        var frame = new CustomFrame();
        var label = new CustomLabel();
        
        frame.add(label);
        frame.pack();
    }
}