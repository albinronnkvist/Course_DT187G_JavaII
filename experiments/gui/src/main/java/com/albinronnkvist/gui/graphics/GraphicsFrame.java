package com.albinronnkvist.gui.graphics;

import com.albinronnkvist.gui.components.CustomFrame;
import java.awt.Color;

public class GraphicsFrame extends CustomFrame {
    private GraphicsPanel panel;

    public GraphicsFrame() {
        panel = new GraphicsPanel();
        this.add(panel);
        
        this.setVisible(true);
    }

    private void pacmanExamples() {
        var panel = new PacmanPanel();
        add(panel);
    }

    private void formExamples(){
        var panel = new CustomFormPanel();
        add(panel);

        panel.getCustomer();
    }
    
    private void customComponentExamples(){
        var label = new BlueReversibleLabel("My component");
        label.reverse();
        label.setForeground(Color.RED);
        add(label);
    }
}
