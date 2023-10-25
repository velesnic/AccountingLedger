package org.example;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reports {

    public LedgerManager ledgerManager = new LedgerManager();
    TransactionManager transactionManager= new TransactionManager();
    ArrayList<Transaction> transactionList;

    public void runReports(ArrayList<Transaction> transactionList){
        boolean isOnline= true;
        while(isOnline){
            System.out.println("What type of report would you like to run? Please enter an option. ");
            System.out.println("1. Month to Date.");
            System.out.println("2. Previous Month.");
            System.out.println("3. Year to Date.");
            System.out.println("4. Previous Year.");
            System.out.println("5. Search by Vendor.");
            System.out.println("0. Return to Ledger.");
            try{
                Scanner reportScanner = new Scanner(System.in);
                int reportChoice = reportScanner.nextInt();
                switch(reportChoice){
                    case 1:
                        //monthtodate
                        break;
                    case 2:
                        //previous month
                        break;
                    case 3:
                        //yeartodate
                        break;
                    case 4:
                        //previous year
                        break;
                    case 5:
                        //search by vendor
                        break;
                    case 0:
                        //return to ledger
                        break;
                    default:
                        System.out.println("Please enter a valid option.");
                }

            }
            catch(Exception ex){
                System.out.println("Not a valid input.");
            }
        }
    }

    public void monthToDate(ArrayList<Transaction> transactionList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");

    }
}
