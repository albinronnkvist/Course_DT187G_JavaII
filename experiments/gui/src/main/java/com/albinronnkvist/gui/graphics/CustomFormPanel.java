package com.albinronnkvist.gui.graphics;

import javax.swing.*;
import java.awt.*;

public class CustomFormPanel extends JPanel {
    private String[] labels = {"First Name", "Last Name", "ID Number", 
                               "Address", "Zip Code", "City", "Email"};
    
    private int[] mnemonicIndex = {0, 0, 0, 0, 0, 0, 0};
    private int[] requiredFields = {0, 1, 2};
    private JLabel[] jLabels = new JLabel[labels.length];
    private JTextField[] jTextFields = new JTextField[labels.length];
    
    public CustomFormPanel() {
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        initComponents();

        int paddingX = 6;
        int paddingY = 6;

        // Layout
        for (int i = 0; i < labels.length; i++) {
            if (i == 0) {
                layout.putConstraint(SpringLayout.NORTH, jLabels[i], paddingY, SpringLayout.NORTH, this);
            } else {
                layout.putConstraint(SpringLayout.NORTH, jLabels[i], paddingY, SpringLayout.SOUTH, jTextFields[i - 1]);
            }
            layout.putConstraint(SpringLayout.WEST, jLabels[i], paddingX, SpringLayout.WEST, this);

            layout.putConstraint(SpringLayout.NORTH, jTextFields[i], 0, SpringLayout.NORTH, jLabels[i]);
            layout.putConstraint(SpringLayout.WEST, jTextFields[i], paddingX, SpringLayout.EAST, jLabels[i]);
        }
    }
    
    private void initComponents() {
        for (int i = 0; i < labels.length; i++) {
            jLabels[i] = new JLabel(labels[i] + ":", JLabel.TRAILING);
            add(jLabels[i]);

            jTextFields[i] = new JTextField(15);
            jLabels[i].setLabelFor(jTextFields[i]);
            jLabels[i].setDisplayedMnemonic(labels[i].charAt(mnemonicIndex[i]));
            add(jTextFields[i]);
        }
    }
    
    public boolean validateFormData() {
        boolean valid = true;
        for (int index : requiredFields) {
            JTextField t = jTextFields[index];
            if (t.getText().isBlank()) {
                valid = false;
                t.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                t.requestFocus();
            } else {
                t.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                t.updateUI();
            }
        }

        return valid;
    }
    
    public Customer getCustomer() {
        Customer c = null;
        if (validateFormData()) {
            c = new Customer(
                jTextFields[0].getText().trim(), // First Name
                jTextFields[1].getText().trim(), // Last Name
                jTextFields[2].getText().trim(), // ID Number
                jTextFields[3].getText().trim(), // Address
                jTextFields[4].getText().trim(), // Zip Code
                jTextFields[5].getText().trim(), // City
                jTextFields[6].getText().trim()  // Email
            );
        }

        return c;
    }

    private class Customer 
    {
        private String firstName;
        private String lastName;
        private String idNumber;
        private String address;
        private String zipCode;
        private String city;
        private String email;
        
        public Customer(String firstName, String lastName, String idNumber, 
                        String address, String zipCode, String city, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = idNumber;
            this.address = address;
            this.zipCode = zipCode;
            this.city = city;
            this.email = email;
        }
    }
}

