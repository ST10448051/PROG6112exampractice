/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itechnician;

// Import necessary JUnit 5 components
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Q.2.8: Unit tests for the Technician class.
 */
class TechnicianTest {

    private ITechnician techLogic;

    @BeforeEach
    void setUp() {
        // Create a new instance before each test
        techLogic = new Technician();
    }

    /**
     * Test Name: CalculatePay_PayCalculatedSuccessfully()
     * Test Purpose: To supply the repair cost and technician rate to the Calculate
     * pay method. The test will determine that the correct value is returned.
     */
    @Test
    void CalculatePay_PayCalculatedSuccessfully() {
        // Arrange
        String repairCost = "5000";
        String rate = "10";
        double expectedPay = 500.0;

        // Act
        double actualPay = techLogic.CalculatePay(repairCost, rate);

        // Assert
        assertEquals(expectedPay, actualPay, "Pay should be 500.0 for 5000 at 10%");
    }

    /**
     * Test Name: CalculatePay_PayCalculatedUnSuccessfully()
     * Test Purpose: To supply the repair cost and technician rate to the Calculate
     * pay method. The test will determine if there is a calculation error.
     */
    @Test
    void CalculatePay_PayCalculatedUnSuccessfully() {
        // Arrange: Use a non-numeric string for cost
        String repairCost = "abc";
        String rate = "10";

        // Act & Assert
        // Test that a NumberFormatException is thrown when calculation fails
        assertThrows(NumberFormatException.class, () -> {
            techLogic.CalculatePay(repairCost, rate);
        }, "Should throw NumberFormatException for non-numeric cost");
    }

    /**
     * Test Name: Validation Test
     * Test Purpose: To prove that the validation is performing as expected.
     * This example validates that repair cost cannot be zero.
     */
    @Test
    void ValidationTest_InvalidRepairCost_ReturnsFalse() {
        // Arrange: Create data with an invalid repair cost (<= 0)
        Data invalidData = new Data("Durban", "Joe Bloggs", "0", "10");

        // Act
        boolean result = techLogic.ValidateData(invalidData);

        // Assert
        assertFalse(result, "Validation should return false for repair cost of 0");
    }
}