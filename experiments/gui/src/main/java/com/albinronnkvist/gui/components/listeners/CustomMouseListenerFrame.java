package com.albinronnkvist.gui.components.listeners;

import com.albinronnkvist.gui.components.CustomFrame;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustomMouseListenerFrame extends CustomFrame implements MouseListener {
    private JLabel label;

    public CustomMouseListenerFrame() {
        label = new JLabel("Interact with the window using the mouse", JLabel.CENTER);
        label.setFont(label.getFont().deriveFont(16.0f));

        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.CENTER);

        this.addMouseListener(this);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered the window");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited the window");
    }
}