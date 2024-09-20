package com.albinronnkvist.gui.components;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomButtonFrame extends CustomFrame { // implements ActionListener

    private JButton button;

    public CustomButtonFrame() {
        var icon = new ImageIcon(getClass().getResource("/logo.png"));
        button = new JButton();
        button.setText("Click me!");
        button.setBounds(200, 100, 200, 50);
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.RIGHT);
        button.setVerticalTextPosition(JButton.CENTER);

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
