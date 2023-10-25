package org.example;

import java.util.ArrayList;
import java.util.Scanner;
public class Ledger {
    LedgerManager ledgerManager = new LedgerManager();
    static TransactionManager transactionManager= new TransactionManager();
    ArrayList<Transaction> transactionList;
    static Reports reports = new Reports();


    public void ledgerMenu(ArrayList<Transaction> transactionList){
        Scanner ledgerscanner = new Scanner(System.in);
        boolean isOnline= true;
        while(isOnline) {
            System.out.println("Welcome to your Account Ledger ");
            System.out.println("Please select an option.");
            System.out.println("A. Display ALL Entries in Ledger.");
            System.out.println("D. Display Only Deposits in Ledger.");
            System.out.println("P. Display Only Payments in Ledger.");
            System.out.println("R. Run reports in Ledger.");
            System.out.println("H. Return to Home Page.");
            try {
                String ledgerChoice = ledgerscanner.nextLine().trim();
                switch (ledgerChoice.toLowerCase()) {
                    case "a":
                        ledgerManager.displayAllEntries(transactionList);
                        break;
                    case "d":
                        ledgerManager.displayDeposits(transactionList);
                        break;
                    case "p":
                        ledgerManager.displayPayments(transactionList);
                        break;
                    case "r":
                        reports.runReports(transactionList);
                        break;
                    case "h":
                        isOnline=false;
                        break;
                    default:
                        System.out.println("Please enter one of the following options: A, D, P, or R.");
                }

            } catch (Exception ex) {
                System.out.println("Not a valid option.");
            }
        }
    }


}
