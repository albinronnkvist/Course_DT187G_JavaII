package com.albinronnkvist.gui.components.listeners;

import com.albinronnkvist.gui.components.CustomFrame;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomKeyListenerFrame extends CustomFrame implements KeyListener {
    private JLabel label;

    public CustomKeyListenerFrame() {
        label = new JLabel("Press any key...", JLabel.CENTER);
        label.setFont(label.getFont().deriveFont(16.0f));

        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.CENTER);

        this.addKeyListener(this);
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed code: " + e.getKeyCode());
        System.out.println("Key Pressed char: " + e.getKeyChar());
        System.out.println("Key Pressed text: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released code: " + e.getKeyCode());
        System.out.println("Key Released char: " + e.getKeyChar());
        System.out.println("Key Released text: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        label.setText("Key pressed: " + e.getKeyChar());
    }
}
