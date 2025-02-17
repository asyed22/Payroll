package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class AppTest {
  @Test
  public void testValidInput() {
      String input = "30\n0\n20\n1\n";
      String expectedOutput = "Welcome to the Payroll Program!\n" +
              "How many hours did you work this week? " +
              "How many children do you have? " +
              "Enter your pay rate per hour: \n\nWhich life insurance plan do you want to select?\n" +
              "  (1) no plan\n" +
              "  (2) single plan\n" +
              "  (3) married plan\n" +
              "  (4) married with children plan\n" +
              "Enter your choice: LifeIns:   $0.00\n\nThank you for using the Payroll Program!";
      simulateInputAndVerify(input, expectedOutput);
  }

  @Test
  public void testInvalidLifeInsuranceOption() {
      String input = "30\n0\n20\n4\n1\n";
      String expectedOutput = "Welcome to the Payroll Program!\n" +
              "How many hours did you work this week? " +
              "How many children do you have? " +
              "Enter your pay rate per hour: \n" +
              "Which life insurance plan do you want to select?\n" +
              "  (1) no plan\n" +
              "  (2) single plan\n" +
              "  (3) married plan\n" +
              "  (4) married with children plan\n" +
              "Enter your choice: Sorry! You need at least one child to select that plan.\n" +
              "Enter your choice: LifeIns:   $0.00\n\nThank you for using the Payroll Program!";
      simulateInputAndVerify(input, expectedOutput);
  }

  @Test
  public void testMultipleHoursWorked() {
      String input = "50\n2\n18\n2\n";
      String expectedOutput = "Welcome to the Payroll Program!\n" +
              "How many hours did you work this week? " +
              "How many children do you have? " +
              "Enter your pay rate per hour: \nWhich life insurance plan do you want to select?" +
              "  (1) no plan\n" +
              "  (2) single plan\n" +
              "  (3) married plan\n" +
              "  (4) married with children plan\n" +
              "Enter your choice: LifeIns:   $5.00\n\nThank you for using the Payroll Program!";
      simulateInputAndVerify(input, expectedOutput);
  }

  private void simulateInputAndVerify(String input, String expectedOutput) {
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      PrintStream printStream = new PrintStream(outputStream);
      System.setOut(printStream);
      Scanner sc = new Scanner(input);
      System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
      App.main(new String[0]);
      String output = outputStream.toString();
      assertTrue(output.contains(expectedOutput), "Expected output: " + expectedOutput + "\nActual output: " + output);
  }
}
