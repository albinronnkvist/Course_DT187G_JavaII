package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomOptionPaneFrame extends CustomFrame implements ActionListener {
    private JButton button;

    public CustomOptionPaneFrame() {
        button = new JButton("Show Dialog");

        button.addActionListener(this);

        this.add(button);        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to proceed?",
                    "Confirmation",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
    
            switch (response) {
                case JOptionPane.YES_OPTION:
                    JOptionPane.showMessageDialog(this, "You selected: Yes");
                    break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(this, "You selected: No");
                    break;
                case JOptionPane.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(this, "You selected: Cancel");
                    break;
                case JOptionPane.CLOSED_OPTION:
                    JOptionPane.showMessageDialog(this, "Dialog was closed");
                    break;
                default:
                    break;
            }
        }
    }
}
