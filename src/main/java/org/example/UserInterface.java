package org.example;

import java.util.Scanner;

public class UserInterface {
    public void homeScreen() {
        System.out.println("Welcome to Velesnic Accounting Ledger.");
        System.out.println("What is your username?");
        try {
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            System.out.println("Welcome " + username);
            boolean isOnline = true;
            while (isOnline) {
                System.out.println("What would you like to do? Select a letter.");
                System.out.println("D. Add Deposit.");
                System.out.println("P. Make Debit Payment.");
                System.out.println("L. Display Ledger Screen.");
                System.out.println("X. Exit Velesnic Accounting Ledger.");
                try {
                    String homescreenChoice = scanner.nextLine();

                    switch(homescreenChoice.toLowerCase()){
                        case "d":
                         //add deposit to csv file
                            break;
                        case "p":
                            //make debit payment// asks user for debit information and saves to csv file
                            break;
                        case "l":
                            //displays ledger screen with newest entries first
                            break;
                        case "x":
                            System.out.println("Goodbye :)");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Please enter one of the following options: D, P, L, or X.");
                    }




                } catch (Exception ex) {
                    System.out.println("Please enter one of the following options: D, P, L, or X. ");
                    scanner.nextLine(); //allows user to enter in another option
                }
            }

        } catch (Exception ex) {
            System.out.println("Could not verify username.");
        }


    }
}

