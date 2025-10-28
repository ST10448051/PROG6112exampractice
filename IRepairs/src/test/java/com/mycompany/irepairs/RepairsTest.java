/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.irepairs;

// Import necessary JUnit 5 components
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Q.1.5: Unit tests for the Repairs class.
 * This class requires the JUnit 5 library.
 */
class RepairsTest {

    private Repairs repairCalculator;

    @BeforeEach
    void setUp() {
        // Create a new instance before each test
        repairCalculator = new Repairs();
    }

    /**
     * Test Name: CalculateCosts_ReturnsRepairCosts
     * Test Purpose: To supply the repair costs to the Repair Costs method.
     * The test will determine that the correct total repair costs are returned.
     */
    @Test
    void CalculateCosts_ReturnsRepairCosts() {
        // Arrange: Data for Joe Bloggs
        double[] costs = {8000.0, 2500.0, 5000.0};
        double expectedTotal = 15500.0;

        // Act: Call the method being tested
        double actualTotal = repairCalculator.RepairCosts(costs);

        // Assert: Check if the actual result matches the expected result
        assertEquals(expectedTotal, actualTotal, "Total repair costs should be 15500.0");
    }

    /**
     * Test Name: CalculatePay_ReturnsExpectedPay
     * Test Purpose: To supply a total repair amount to the technician, pay method.
     * The test will determine that the correct pay has been calculated.
     */
    @Test
    void CalculatePay_ReturnsExpectedPay() {
        // Arrange: Total amount for Joe Bloggs
        double totalAmount = 15500.0;
        double expectedPay = 1550.0; // 10% of 15500.0

        // Act: Call the method being tested
        double actualPay = repairCalculator.TechnicianPay(totalAmount);

        // Assert: Check if the actual pay matches the expected 10%
        assertEquals(expectedPay, actualPay, "Technician pay should be 10% of the total");
    }

    /**
     * Test Name: TopTechnician_ReturnsTopPosition
     * Test Purpose: To supply total repairs for each technician to the top technician
     * method. The test will determine the top-performing technician.
     */
    @Test
    void TopTechnician_ReturnsTopPosition() {
        // Arrange: Totals for [Joe Bloggs, Jane Doe]
        double[] totals = {15500.0, 14800.0};
        int expectedIndex = 0; // Joe Bloggs is at index 0

        // Act: Call the method being tested
        int actualIndex = repairCalculator.TopTechnician(totals);

        // Assert: Check if the correct index (0) is returned
        assertEquals(expectedIndex, actualIndex, "The index of the top technician should be 0");
    }
}