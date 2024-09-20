package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomSliderFrame extends CustomFrame implements ActionListener {
    private JSlider slider;
    private JButton button;

    public CustomSliderFrame() {
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        button = new JButton("Submit");
        button.addActionListener(this);

        var panel = new JPanel();
        panel.add(slider);
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            int selectedValue = slider.getValue();

            JOptionPane.showMessageDialog(this, "Selected value: " + selectedValue);
        }
    }
}