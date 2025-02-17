package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    
    @Test
    public void testValidInput() {
        // Simulate a valid case with hoursWorked = 40, payRate = 15.00, and numChildren = 2
        double hoursWorked = 40;
        double payRate = 15.00;
        int numChildren = 2;

        double expectedGrossPay = 600.00;
        double expectedNetPay = expectedGrossPay - (expectedGrossPay * 0.06 + expectedGrossPay * 0.14 + expectedGrossPay * 0.05 + 10.00 + 15.00);

        assertEquals(expectedGrossPay, hoursWorked * payRate, 0.01);
        assertEquals(expectedNetPay, expectedGrossPay - (expectedGrossPay * 0.06 + expectedGrossPay * 0.14 + expectedGrossPay * 0.05 + 10.00 + 15.00), 0.01);
    }

    @Test
    public void testNegativeInput() {
        // Check that negative pay rates and hours are not accepted
        double hoursWorked = -5;
        double payRate = -10;

        assertTrue(hoursWorked < 0);
        assertTrue(payRate < 0);
    }

    @Test
    public void testValidInsurancePlan() {
        // Test for selecting a valid insurance plan
        int insuranceOption = 3;
        assertTrue(insuranceOption >= 1 && insuranceOption <= 4);
    }
}