/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.irepairs;
import java.util.Locale;

/**
 * Main application class to run the technician repair report.
 * This class addresses Q.1.1, Q.1.2, and Q.1.3.
 */
public class TechnicianReport {

    public static void main(String[] args) {
        // Set locale to use dots for decimals, as in the sample
        Locale.setDefault(Locale.US);

        // Q.1.1: 2D array for two technicians and three months
        String[] technicians = {"Joe Bloggs", "Jane Doe"};
        String[] months = {"JAN", "FEB", "MAR"};
        double[][] repairsData = {
            {8000.0, 2500.0, 5000.0}, // Joe Bloggs
            {7000.0, 2200.0, 5600.0}  // Jane Doe
        };

        // Instantiate the Repairs class to use its methods
        Repairs repairCalculator = new Repairs();

        // --- Print the Report Header ---
        System.out.println("TECHNICIAN VEHICLE REPAIR REPORT");
        System.out.println("---------------------------------------------------------");
        // Print month headers
        System.out.printf("%-15s", "TECHNICIAN");
        for (String month : months) {
            System.out.printf("%-10s", month);
        }
        System.out.println("\n---------------------------------------------------------");

        // --- Print Monthly Data ---
        for (int i = 0; i < technicians.length; i++) {
            System.out.printf("%-15s", technicians[i]);
            for (int j = 0; j < months.length; j++) {
                System.out.printf("R %-9.1f", repairsData[i][j]);
            }
            System.out.println();
        }
        System.out.println(); // Blank line

        // --- Calculate and Print Totals and Commission ---
        double[] totalRepairs = new double[technicians.length];

        // Q.1.2: Calculate and print total repair amount
        for (int i = 0; i < technicians.length; i++) {
            totalRepairs[i] = repairCalculator.RepairCosts(repairsData[i]);
            System.out.printf("Total vehicle repairs for %s = R %,.1f\n", technicians[i], totalRepairs[i]);
        }
        System.out.println(); // Blank line

        // Q.1.3: Calculate and print 10% pay (commission)
        for (int i = 0; i < technicians.length; i++) {
            double commission = repairCalculator.TechnicianPay(totalRepairs[i]);
            System.out.printf("Repair Commission for %s = R %,.1f\n", technicians[i], commission);
        }
        System.out.println(); // Blank line

        // --- Calculate and Print Top Performer ---
        int topTechIndex = repairCalculator.TopTechnician(totalRepairs);
        String topPerformer = technicians[topTechIndex];
        System.out.println("Top performing vehicle repair technician: " + topPerformer);
    }
}