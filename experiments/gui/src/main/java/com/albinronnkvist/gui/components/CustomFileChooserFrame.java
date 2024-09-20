package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomFileChooserFrame extends CustomFrame implements ActionListener {
    private JButton button;

    public CustomFileChooserFrame() {
        button = new JButton("Select File");
        button.addActionListener(this);

        var panel = new JPanel();
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            var fileChooser = new JFileChooser();
            
            int result = fileChooser.showOpenDialog(this);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                var selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Selected file: " + selectedFile.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(this, "File selection canceled.");
            }
        }
    }
}