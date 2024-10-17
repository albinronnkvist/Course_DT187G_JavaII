package com.albinronnkvist.gui.components;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.FlowLayout;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileChooserFrame extends CustomFrame {
    private FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Files", "txt");

    public CustomFileChooserFrame() {
        this.setLayout(new FlowLayout());

        var openButton = new JButton("Choose File");
        openButton.addActionListener(e -> HandleOpen());

        var saveButton = new JButton("Save File");
        saveButton.addActionListener(e -> HandleSave());

        this.add(openButton);
        this.add(saveButton);
        this.setVisible(true);
    }

    public void HandleOpen() {
        var fileChooser = new JFileChooser();

        var option = fileChooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            var file = fileChooser.getSelectedFile();
            System.out.println("Selected file to open: " + file.getAbsolutePath());
        }
    }

    public void HandleSave() {
        var fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(txtFilter);
        
        var option = fileChooser.showSaveDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            var file = fileChooser.getSelectedFile();

            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Hi Hello How Are You...");
                System.out.println("File saved: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
