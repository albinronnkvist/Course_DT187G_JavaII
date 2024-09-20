package com.albinronnkvist.gui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class CustomButtonFrame extends CustomFrame implements ActionListener {

    private JButton button;

    public CustomButtonFrame() {
        this.button = new JButton();
        this.button.setText("Click me!");
        this.button.setBounds(200, 100, 100, 50);
        button.addActionListener(this);

        this.add(button);

        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.button) {
            System.out.println("You clicked the button!");
        }
    }
}
