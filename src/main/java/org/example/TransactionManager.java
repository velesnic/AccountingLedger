package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManager {

    static ArrayList<Transaction> transactionList = new ArrayList<>();
    public ArrayList<Transaction> TransactionList() {

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
            Scanner scanner = new Scanner(fileInputStream);
            scanner.nextLine();
            String input;
            while (scanner.hasNextLine()) {
                input = scanner.nextLine();
                String[] rowArray = input.split("\\|");

                String date = rowArray[0];
                String time = rowArray[1];
                String description = rowArray[2];
                String vendor = rowArray[3];
                Double amount = Double.parseDouble(rowArray[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);


                transactionList.add(transaction);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not locate file.");
        }
        return transactionList;
    }


    private static void addNewTransactionToFile(Transaction newTransaction){
        try{
            FileWriter newFilewriter= new FileWriter("src/main/resources/transactions.csv", true);
            newFilewriter.write( newTransaction.getDate() + " | " + newTransaction.getTime() + " | " + newTransaction.getDescription() + " | " +
                    newTransaction.getVendor() + " | " + newTransaction.getAmount() + "\n");
            newFilewriter.close();


        }
        catch(IOException ex){
            System.out.println("Could not add transaction to file.");
        }
    }

    static void addNewDeposit() {
        System.out.println("To complete a deposit, please enter the following information.");
        System.out.println("Date (YYYY-MM-DD): ");
        try {
            Scanner scanner = new Scanner(System.in);
            String userDate = scanner.nextLine();
            System.out.println("Time (HH:MM:SS): ");
            String userTime = scanner.nextLine();
            System.out.println("Description: ");
            String userDescription = scanner.nextLine();
            System.out.println("Vendor: ");
            String userVendor = scanner.nextLine();
            System.out.println("Deposit Amount: ");
            double userAmount = scanner.nextDouble();

            Transaction newTransaction = new Transaction(userDate, userTime, userDescription, userVendor, userAmount);
            transactionList.add(newTransaction);
            addNewTransactionToFile(newTransaction);
            System.out.println("Deposit of " + userAmount + " successfully added to file.");
        } catch (Exception ex) {
            System.out.println("Please enter a valid input.");
        }

    }

    static void makePayment(){
        System.out.println("To make a payment, please enter the following information.");
        System.out.println("Date (YYYY-MM-DD): ");
        try {
            Scanner scanner = new Scanner(System.in);
            String userDate = scanner.nextLine();
            System.out.println("Time (HH:MM:SS): ");
            String userTime = scanner.nextLine();
            System.out.println("Description: ");
            String userDescription = scanner.nextLine();
            System.out.println("Vendor: ");
            String userVendor = scanner.nextLine();
            System.out.println("Payment Amount: ");
            double userAmount = scanner.nextDouble();

            Transaction newTransaction = new Transaction(userDate, userTime, userDescription, userVendor, userAmount);
            transactionList.add(newTransaction);
            addNewTransactionToFile(newTransaction);
            System.out.println("Payment of " + userAmount + " successfully added to file.");
        } catch (Exception ex) {
            System.out.println("Please enter a valid input.");
        }

    }



}