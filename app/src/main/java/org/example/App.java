package org.example;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to the Payroll Program!");

    double hoursWorked;
    do {
      System.out.print("How many hours did you work this week? ");
      hoursWorked = sc.nextDouble();
      if (hoursWorked < 0) {
        System.out.println("Hours worked cannot be negative. Please enter a valid number.");
      }
    } while (hoursWorked < 0);

    int numChildren;
    System.out.print("How many children do you have? ");
    numChildren = sc.nextInt();

    double payRate;
    do {
      System.out.print("Enter your pay rate per hour: ");
      payRate = sc.nextDouble();
      if (payRate < 0) {
        System.out.println("Pay rate cannot be negative. Please enter a valid rate.");
      }
    } while (payRate < 0);

    double grossPay = 0;
    if (hoursWorked > 40) {
      grossPay = 40 * payRate + (hoursWorked - 40) * (payRate * 1.5);
    } else {
      grossPay = hoursWorked * payRate;
    }

    double socSec = grossPay * 0.06;
    double fedTax = grossPay * 0.14;
    double stTax = grossPay * 0.05;
    double unionDues = 10.00;
    double insurancePayment;
    if (numChildren >= 3) {
      insurancePayment = 35.00;
    } else {
      insurancePayment = 15.00;
    }

    double netPay = grossPay - (socSec + fedTax + stTax + unionDues + insurancePayment);

    int insuranceOption;
    do {
      System.out.println("\nWhich life insurance plan do you want to select?");
      System.out.println("  (1) no plan");
      System.out.println("  (2) single plan");
      System.out.println("  (3) married plan");
      System.out.println("  (4) married with children plan");

      System.out.print("Enter your choice: ");
      insuranceOption = sc.nextInt();

      if (insuranceOption == 4 && numChildren == 0) {
        System.out.println("Sorry! You need at least one child to select that plan.");
      } else if (insuranceOption < 1 || insuranceOption > 4) {
        System.out.println("Invalid option selected. Please choose a valid option.");
      }
    } while (insuranceOption == 4 && numChildren == 0 || insuranceOption < 1 || insuranceOption > 4);

    double lifeInsuranceCost = 0;
    switch (insuranceOption) {
      case 1:
        lifeInsuranceCost = 0;
        break;
      case 2:
        lifeInsuranceCost = 5.00;
        break;
      case 3:
        lifeInsuranceCost = 10.00;
        break;
      case 4:
        lifeInsuranceCost = 15.00;
        break;
    }

    netPay -= lifeInsuranceCost;

    System.out.println("\nPayroll Stub:\n");
    System.out.printf("   Hours:   %.1f\n", hoursWorked);
    System.out.printf("    Rate:   %.2f $/hr\n", payRate);
    System.out.printf("   Gross:   $%.2f\n", grossPay);
    System.out.printf("\n  SocSec:   $%.2f\n", socSec);
    System.out.printf("  FedTax:   $%.2f\n", fedTax);
    System.out.printf("   StTax:   $%.2f\n", stTax);
    System.out.printf("   Union:   $%.2f\n", unionDues);
    System.out.printf("     Ins:   $%.2f\n", insurancePayment);
    System.out.printf("\n     Net:   $%.2f\n", netPay);

    System.out.printf(" LifeIns:   $%.2f\n", lifeInsuranceCost);
    System.out.printf("\n     Net:   $%.2f\n", netPay);

    System.out.println("\nThank you for using the Payroll Program!");
    sc.close();
  }
}