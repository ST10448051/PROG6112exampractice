/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itechnician;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Q.2.1: The main Java GUI application.
 * This class creates the form and handles all menu events.
 */
public class TechnicianGUI extends JFrame implements ActionListener {

    // Q.2.1: GUI Components
    private JComboBox<String> cmbLocation;
    private JTextField txtName;
    private JTextField txtCost;
    private JTextField txtRate;
    private JTextArea txaReport;

    // Q.2.2: Menu Items
    private JMenuItem itemExit;
    private JMenuItem itemProcess;
    private JMenuItem itemClear;
    private JMenuItem itemSave;

    // Business logic class
    private ITechnician techLogic;

    // Use Locale for consistent currency/decimal formatting
    private static final Locale locale = Locale.US;
    
    public TechnicianGUI() {
        techLogic = new Technician();
        buildGUI();
    }

    private void buildGUI() {
        // --- Basic Frame Setup ---
        setTitle("TECHNICIAN");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Q.2.2: Menu System ---
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu menuFile = new JMenu("File");
        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        menuFile.add(itemExit);
        
        // Tools Menu
        JMenu menuTools = new JMenu("Tools");
        itemProcess = new JMenuItem("Process Report");
        itemClear = new JMenuItem("Clear");
        itemSave = new JMenuItem("Save Report");
        
        itemProcess.addActionListener(this);
        itemClear.addActionListener(this);
        itemSave.addActionListener(this);
        
        menuTools.add(itemProcess);
        menuTools.add(itemClear);
        menuTools.add(itemSave);
        
        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // --- Q.2.1: Form Components Panel ---
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0: Location
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("TECHNICIAN LOCATION:"), gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        String[] locations = {"Cape Town", "Durban", "Pretoria"};
        cmbLocation = new JComboBox<>(locations);
        panel.add(cmbLocation, gbc);

        // Row 1: Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("TECHNICIAN NAME:"), gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtName = new JTextField(15);
        panel.add(txtName, gbc);

        // Row 2: Repair Cost
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("REPAIR COST:"), gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtCost = new JTextField(15);
        panel.add(txtCost, gbc);

        // Row 3: Technician Rate
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("TECHNICIAN RATE:"), gbc);
        
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtRate = new JTextField(15);
        panel.add(txtRate, gbc);
        
        // Row 4: Report Label
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(new JLabel("TECHNICIAN REPORT:"), gbc);

        // Row 5: Text Area
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Span both columns
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; // Allow text area to grow
        txaReport = new JTextArea(10, 30);
        txaReport.setEditable(false);
        txaReport.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel.add(new JScrollPane(txaReport), gbc);

        // Add panel to frame and display
        add(panel);
        pack(); // Pack to fit components
        setMinimumSize(getSize());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == itemProcess) {
            processReport();
        } else if (source == itemClear) {
            clearForm();
        } else if (source == itemSave) {
            saveReport();
        } else if (source == itemExit) {
            // Q.2.3: Close the application
            System.exit(0);
        }
    }

    /**
     * Q.2.4: Process the report when the menu item is clicked.
     */
    private void processReport() {
        Data inputData = getFormData();
        
        if (techLogic.ValidateData(inputData)) {
            try {
                // Data is valid, proceed with calculation
                double pay = techLogic.CalculatePay(inputData.repairCost, inputData.rate);
                
                // Format data for display
                double costVal = Double.parseDouble(inputData.repairCost);
                double rateVal = Double.parseDouble(inputData.rate);

                NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
                // The sample shows "R 5000.0", not "$5,000.00".
                // We will custom format to match the sample.
                
                String costStr = String.format(locale, "R %.1f", costVal);
                String rateStr = String.format(locale, "%.1f%%", rateVal);
                String payStr = String.format(locale, "R %.1f", pay);

                // Build the report string
                String report = "TECHNICIAN LOCATION: " + inputData.location + "\n"
                              + "TECHNICIAN NAME: " + inputData.name + "\n"
                              + "REPAIR COST: " + costStr + "\n"
                              + "TECHNICIAN RATE: " + rateStr + "\n"
                              + "CALCULATED PAY: " + payStr;
                
                txaReport.setText(report);

            } catch (NumberFormatException ex) {
                // This should not happen if validation is correct, but good to have
                showError("A calculation error occurred.");
            }
        } else {
            // Validation failed
            showError("Invalid input. Please check all fields.\n"
                    + "- Location and Name cannot be empty.\n"
                    + "- Cost and Rate must be numbers greater than 0.");
        }
    }

    /**
     * Q.2.6: Clear all fields to their default state.
     */
    private void clearForm() {
        cmbLocation.setSelectedIndex(0); // Reset to "Cape Town"
        txtName.setText("");
        txtCost.setText("");
        txtRate.setText("");
        txaReport.setText("");
    }

    /**
     * Q.2.5: Save the report to a text file named "report.txt".
     */
    private void saveReport() {
        Data inputData = getFormData();
        
        // First, validate the data just like processing
        if (techLogic.ValidateData(inputData)) {
            try {
                double pay = techLogic.CalculatePay(inputData.repairCost, inputData.rate);
                double costVal = Double.parseDouble(inputData.repairCost);
                double rateVal = Double.parseDouble(inputData.rate);

                // Format strings to match the file sample
                String costStr = String.format(locale, "R %.1f", costVal);
                String rateStr = String.format(locale, "%.1f%%", rateVal);
                String payStr = String.format(locale, "R %.1f", pay);
                String separator = "******************************";

                // Build the report string for the file
                String fileReport = "TECHNICIAN REPORT\n"
                                  + separator + "\n"
                                  + "TECHNICIAN LOCATION: " + inputData.location + "\n"
                                  + "TECHNICIAN NAME: " + inputData.name + "\n"
                                  + "REPAIR COST: " + costStr + "\n"
                                  + "TECHNICIAN RATE: " + rateStr + "\n"
                                  + "CALCULATED PAY: " + payStr + "\n"
                                  + separator;
                
                // Write to file
                try (PrintWriter out = new PrintWriter(new FileWriter("report.txt"))) {
                    out.print(fileReport);
                    JOptionPane.showMessageDialog(this,
                            "Report successfully saved to report.txt",
                            "Save Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    showError("Error saving file: " + ex.getMessage());
                }

            } catch (NumberFormatException ex) {
                showError("A calculation error occurred.");
            }
        } else {
            // No valid data to save
            showError("No valid data to save. Please process a report first.");
        }
    }

    // --- Helper Methods ---
    
    /**
     * @return A Data object populated with current form inputs.
     */
    private Data getFormData() {
        String location = (String) cmbLocation.getSelectedItem();
        String name = txtName.getText();
        String cost = txtCost.getText();
        String rate = txtRate.getText();
        return new Data(location, name, cost, rate);
    }
    
    /**
     * Shows a formatted error message dialog.
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
    }

    // --- Main Method to run the application ---
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new TechnicianGUI());
    }
}