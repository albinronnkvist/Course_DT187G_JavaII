package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomComboBoxFrame extends CustomFrame implements ActionListener {
    private JComboBox<String> comboBox;
    private JButton button;

    public CustomComboBoxFrame() {
        String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};
        comboBox = new JComboBox<>(options);

        button = new JButton("Submit");
        button.addActionListener(this);

        var panel = new JPanel();
        panel.add(comboBox);
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String selectedOption = (String) comboBox.getSelectedItem();

            JOptionPane.showMessageDialog(this, "You selected: " + selectedOption);
        }
    }
}
