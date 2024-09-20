package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomDragAndDropFrame extends CustomFrame {

    private JLabel label;
    private JTextField textField;

    public CustomDragAndDropFrame() {
        label = new JLabel("Drag this text");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setTransferHandler(new TransferHandler("text"));

        label.addMouseListener(createDragMouseAdapter());

        textField = new JTextField(20);
        textField.setTransferHandler(new TransferHandler("text"));

        var panel = new JPanel();
        panel.add(label);
        panel.add(textField);

        this.add(panel);
        this.setVisible(true);
    }

    private MouseAdapter createDragMouseAdapter() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                var component = (JComponent) e.getSource();
                var handler = component.getTransferHandler();
                handler.exportAsDrag(component, e, TransferHandler.COPY);
            }
        };
    }
}
