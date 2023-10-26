package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reports {

    public LedgerManager ledgerManager = new LedgerManager();
    TransactionManager transactionManager= new TransactionManager();
    public Ledger ledger = new Ledger();
    ArrayList<Transaction> transactionList;

    public void runReports(ArrayList<Transaction> transactionList){
        transactionManager.TransactionList();
        boolean isOnline= true;
        while(isOnline){
            System.out.println("What type of report would you like to run? Please enter an option. ");
            System.out.println("1. Month to Date.");
            System.out.println("2. Previous Month.");
            System.out.println("3. Year to Date.");
            System.out.println("4. Previous Year.");
            System.out.println("5. Search by Vendor.");
            System.out.println("0. Go back.");
            try{
                Scanner reportScanner = new Scanner(System.in);
                int reportChoice = reportScanner.nextInt();
                switch(reportChoice){
                    case 1 :
                        monthToDate(transactionList);
                        break;
                    case 2 :
                        previousMonth(transactionList);
                        break;
                    case 3 :
                        yearToDate(transactionList);
                        break;
                    case 4 :
                        previousYear(transactionList);
                        break;
                    case 5 :
                        searchByVendor(transactionList);
                        break;
                    case 0 :
                        ledger.ledgerMenu(transactionList);
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

    public void printReport(ArrayList<Transaction> transactions){
        if(transactions.isEmpty()){
            System.out.println("No transactions found.");
            return;
        }
        else {
            System.out.println("Transactions:");
            for(Transaction transaction : transactions){
                System.out.println(transaction);
            }

        }
    }

    public void monthToDate(ArrayList<Transaction> transactionList) {
        transactionManager.TransactionList();
        LocalDate todaysDate = LocalDate.now();
        ArrayList<Transaction> reportOfTransactions = new ArrayList<>();
        for(Transaction transaction : transactionList){
            if(transaction.getDate().getMonth() == todaysDate.getMonth()){
                reportOfTransactions.add(transaction);
            }
        }
        printReport(reportOfTransactions);
    }

    public void previousMonth(ArrayList<Transaction> transactionList){
        transactionManager.TransactionList();
        LocalDate todaysDate = LocalDate.now();
        LocalDate oneMonthAgo = todaysDate.minusMonths(1);
        ArrayList<Transaction> reportOfTransactions = new ArrayList<>();
        for(Transaction transaction : transactionList){
            LocalDate transactionDate =transaction.getDate();
            if(transactionDate.getYear() == oneMonthAgo.getYear() &&
                    transactionDate.getMonthValue() == oneMonthAgo.getMonthValue()) {{
                        reportOfTransactions.add(transaction);
                     }
            }
        }
        printReport(reportOfTransactions);

    }

    public void yearToDate(ArrayList<Transaction> transactionList){
        transactionManager.TransactionList();
        LocalDate todaysDate = LocalDate.now();
        ArrayList<Transaction> reportOfTransactions = new ArrayList<>();
        for(Transaction transaction : transactionList) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.getYear() == todaysDate.getYear()) {
                reportOfTransactions.add(transaction);
            }
        }
        printReport(reportOfTransactions);
    }


    public void previousYear(ArrayList<Transaction> transactionList){
        transactionManager.TransactionList();
        LocalDate todaysDate = LocalDate.now();
        LocalDate oneYearAgo = todaysDate.minusYears(1);
        ArrayList<Transaction> reportOfTransactions = new ArrayList<>();
        for(Transaction transaction : transactionList) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.getYear() == oneYearAgo.getYear()) {
                reportOfTransactions.add(transaction);
            }
        }
        printReport(reportOfTransactions);
    }

    public void searchByVendor(ArrayList<Transaction> transactionList){
        transactionManager.TransactionList();
        Scanner reportScanner = new Scanner(System.in);
        System.out.println("Enter Vendor Name: ");
        try{
            String vendorName = reportScanner.next();
            ArrayList<Transaction> reportOfTransactions = new ArrayList<>();
            for(Transaction transaction : transactionList){
                if(transaction.getVendor().trim().equalsIgnoreCase(vendorName)){
                    reportOfTransactions.add(transaction);
                }
            }
            printReport(reportOfTransactions);
        }
        catch(Exception ex){
            System.out.println("Not a valid input.");
        }


    }

}
