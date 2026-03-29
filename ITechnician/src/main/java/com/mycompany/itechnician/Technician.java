/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itechnician;

/**
 *
 * @author lab_services_student
 */
/**
 * Q.2.7: The Technician class implementing the ITechnician interface.
 * This class contains the business logic for calculation and validation.
 */
public class Technician implements ITechnician {

    /**
     * Calculates pay based on cost and rate.
     * Per the sample screenshot: 5000 (cost) and 10 (rate) -> 500.0 (pay).
     * This means the calculation is cost * (rate / 100).
     */
    @Override
    public double CalculatePay(String repairCost, String rate) throws NumberFormatException {
        // This method assumes data is already validated, but can throw
        // NumberFormatException as required by the unit test Q.2.8
        double cost = Double.parseDouble(repairCost);
        double techRate = Double.parseDouble(rate);
        
        return cost * (techRate / 100.0);
    }

    /**
     * Validates the input data based on the rules in Q.2.7.
     */
    @Override
    public boolean ValidateData(Data dataToValidate) {
        
        // Rule 1: Technician Location cannot be empty
        if (dataToValidate.location == null || dataToValidate.location.trim().isEmpty()) {
            return false;
        }

        // Rule 2: Technician Name cannot be empty
        if (dataToValidate.name == null || dataToValidate.name.trim().isEmpty()) {
            return false;
        }

        // Rule 3 & 4: Repair Costs and Rate
        try {
            // Rule 3: Repair Cost cannot be <= 0
            double cost = Double.parseDouble(dataToValidate.repairCost);
            if (cost <= 0) {
                return false;
            }

            // Rule 4: Technician Rate cannot be <= 0
            double rate = Double.parseDouble(dataToValidate.rate);
            if (rate <= 0) {
                return false;
            }
        } catch (NumberFormatException | NullPointerException e) {
            // Data was not a valid number
            return false;
        }

        // All rules passed
        return true;
    }
}