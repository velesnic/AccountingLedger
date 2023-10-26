package org.example;

import java.util.Scanner;

public class UserInterface {

TransactionManager transactionManager= new TransactionManager();

Ledger ledger = new Ledger();
    public void homeScreen() {
        transactionManager.TransactionList();
        System.out.println("Welcome to Velesnic Accounting Ledger.");
        System.out.println("What is your username?");
        try {
            Scanner homescanner = new Scanner(System.in);
            String username = homescanner.nextLine();
            System.out.println("Welcome " + username + "!");
            boolean isOnline = true;
            while (isOnline) {
                System.out.println("What would you like to do? Select a letter.");
                System.out.println("D. Add Deposit.");
                System.out.println("P. Make Debit Payment.");
                System.out.println("L. Display Ledger Screen.");
                System.out.println("X. Exit Velesnic Accounting Ledger.");
                    try {
                        String homescreenChoice = homescanner.nextLine();

                        switch (homescreenChoice.toLowerCase()) {
                            case "d":
                                transactionManager.addNewDeposit();
                                break;
                            case "p":
                                transactionManager.makePayment();
                                break;
                            case "l":
                                ledger.ledgerMenu(transactionManager.transactionList);
                                break;
                            case "x":
                                System.out.println("Goodbye :)");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Please enter one of the following options: D, P, L, or X.");
                        }


                    } catch (Exception ex) {
                        System.out.println("Not a valid option. ");
                    }
                }


        } catch (Exception ex) {
            System.out.println("Could not verify username.");
        }
    }
}

