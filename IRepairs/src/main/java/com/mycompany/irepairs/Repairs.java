/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.irepairs;
import java.util.Arrays;

/**
 * Q.1.4: Repairs class that implements the IRepairs interface.
 */
public class Repairs implements IRepairs {

    /**
     * Calculates the total sum of repairs for one technician.
     * This fulfills the test case: CalculateCosts_ReturnsRepairCosts()
     */
    @Override
    public double RepairCosts(double[] repairCosts) {
        double total = 0.0;
        for (double cost : repairCosts) {
            total += cost;
        }
        return total;
    }

    /**
     * Calculates the 10% commission on a total repair amount.
     * This fulfills Q.1.3 and the test case: CalculatePay_ReturnsExpectedPay()
     */
    @Override
    public double TechnicianPay(double amount) {
        // 10% commission
        return amount * 0.10;
    }

    /**
     * Finds the index of the technician with the highest total repairs.
     * This fulfills the test case: TopTechnician_ReturnsTopPosition()
     */
    @Override
    public int TopTechnician(double[] repairs) {
        if (repairs == null || repairs.length == 0) {
            // Return -1 or throw an exception for an empty/null array
            return -1; 
        }

        int topIndex = 0;
        double maxRepairs = repairs[0];

        for (int i = 1; i < repairs.length; i++) {
            if (repairs[i] > maxRepairs) {
                maxRepairs = repairs[i];
                topIndex = i;
            }
        }
        return topIndex;
    }
}