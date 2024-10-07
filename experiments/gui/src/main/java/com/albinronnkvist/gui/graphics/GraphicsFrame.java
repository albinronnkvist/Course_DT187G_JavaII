package com.albinronnkvist.gui.graphics;

import com.albinronnkvist.gui.components.CustomFrame;

public class GraphicsFrame extends CustomFrame {
    private GraphicsPanel panel;

    public GraphicsFrame() {
        panel = new GraphicsPanel();
        this.add(panel);
        
        this.setVisible(true);
    }
}
