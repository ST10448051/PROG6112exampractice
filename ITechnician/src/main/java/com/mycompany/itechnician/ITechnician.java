/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.itechnician;

/**
 *
 * @author lab_services_student
 */
public interface ITechnician {

    /**
     * Calculates the technician's pay from string inputs.
     * @param repairCost The cost of the repair as a String.
     * @param rate The technician's rate as a String (e.g., "10" for 10%).
     * @return The calculated pay.
     * @throws NumberFormatException if strings cannot be parsed to numbers.
     */
    double CalculatePay(String repairCost, String rate) throws NumberFormatException;

    /**
     * Validates all form inputs based on the rules in Q.2.7.
     * @param dataToValidate A Data object containing all string inputs from the GUI.
     * @return true if all data is valid, false otherwise.
     */
    boolean ValidateData(Data dataToValidate);
}