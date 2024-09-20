package com.albinronnkvist.gui.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class CustomMenuBarFrame extends CustomFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openItem, saveItem, exitItem;

    public CustomMenuBarFrame() {
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");

        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        fileMenu.setMnemonic(KeyEvent.VK_F); // Open file menu with Alt+F

        menuBar.add(fileMenu);

        this.setJMenuBar(menuBar);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
            JOptionPane.showMessageDialog(this, "Open clicked");
        } else if (e.getSource() == saveItem) {
            JOptionPane.showMessageDialog(this, "Save clicked");
        } else if (e.getSource() == exitItem) {
            System.exit(0);
        }
    }
}
