package com.albinronnkvist.gui.components;

import javax.swing.JButton;

public class CustomButtonFrame extends CustomFrame { // implements ActionListener

    private JButton button;

    public CustomButtonFrame() {
        this.button = new JButton();
        this.button.setText("Click me!");
        this.button.setBounds(200, 100, 100, 50);
        button.addActionListener(e -> System.out.println("You clicked the button!")); // Shortcut

        this.add(button);

        this.setLayout(null);
        this.setVisible(true);
    }

/*     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.button) {
            System.out.println("You clicked the button!");
        }
    } */
}
