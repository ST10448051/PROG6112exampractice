/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.irepairs;

/**
 * Q.1.4: IRepairs interface containing the required method signatures.
 */
public interface IRepairs {
    /**
     * Calculates the total repair costs from an array of individual repairs.
     * @param repairCosts An array of repairs for a single technician.
     * @return The total sum of repair costs.
     */
    double RepairCosts(double[] repairCosts);

    /**
     * Calculates the technician's 10% pay (commission) based on a total amount.
     * @param amount The total repair amount.
     * @return The 10% commission.
     */
    double TechnicianPay(double amount);

    /**
     * Finds the index of the top-performing technician from an array of totals.
     * @param repairs An array containing the total repair amounts for each technician.
     * @return The 0-based index of the technician with the highest total.
     */
    int TopTechnician(double[] repairs);
}