package com.atm.main;

import com.atm.atm.ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        atm.start();

        try {
            // Authenticate user
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();
            atm.authenticateUser(userId, pin);

            while (true) {
                System.out.println("\n1. Display Accounts");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 6) {
                    System.out.println("Thank you for using the ATM!");
                    break;
                }

                switch (choice) {
                    case 1:
                        atm.displayAccounts();
                        break;
                    case 2:
                        System.out.print("Enter account number: ");
                        String depAcc = scanner.nextLine();
                        System.out.print("Enter amount: ");
                        double depAmount = scanner.nextDouble();
                        atm.deposit(depAcc, depAmount);
                        break;
                    case 3:
                        System.out.print("Enter account number: ");
                        String withAcc = scanner.nextLine();
                        System.out.print("Enter amount: ");
                        double withAmount = scanner.nextDouble();
                        atm.withdraw(withAcc, withAmount);
                        break;
                    case 4:
                        System.out.print("Enter from account number: ");
                        String fromAcc = scanner.nextLine();
                        System.out.print("Enter to account number: ");
                        String toAcc = scanner.nextLine();
                        System.out.print("Enter amount: ");
                        double transAmount = scanner.nextDouble();
                        atm.transfer(fromAcc, toAcc, transAmount);
                        break;
                    case 5:
                        System.out.print("Enter account number: ");
                        String balAcc = scanner.nextLine();
                        atm.checkBalance(balAcc);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}