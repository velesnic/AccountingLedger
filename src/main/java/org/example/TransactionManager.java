package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManager {

    public ArrayList<Transaction> transactionList = new ArrayList<>();
    public ArrayList<Transaction> TransactionList() {

        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
            Scanner tmscanner = new Scanner(fileInputStream);
            tmscanner.nextLine();
            String input;
            while (tmscanner.hasNextLine()) {
                input = tmscanner.nextLine();
                String[] rowArray = input.split("\\|");

                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalDate date = LocalDate.parse(rowArray[0].trim(), dateFormatter);
                LocalTime time = LocalTime.parse(rowArray[1].trim(), timeFormatter);
                String description = rowArray[2];
                String vendor = rowArray[3];
                double amount = Double.parseDouble(rowArray[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);


                transactionList.add(transaction);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not locate file.");
        }
        return transactionList;
    }


    public void addNewTransactionToFile(Transaction newTransaction){
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

    public void addNewDeposit() {
        System.out.println("To complete a deposit, please enter the following information.");
        System.out.println("Date (YYYY-MM-DD): ");
        try {
            Scanner ndscanner = new Scanner(System.in);
            LocalDate userDate = LocalDate.parse(ndscanner.nextLine());
            System.out.println("Time (HH:MM:SS): ");
            LocalTime userTime = LocalTime.parse(ndscanner.nextLine());
            System.out.println("Description: ");
            String userDescription = ndscanner.nextLine();
            System.out.println("Vendor: ");
            String userVendor = ndscanner.nextLine();
            System.out.println("Deposit Amount: ");
            double userAmount = ndscanner.nextDouble();
            if(userAmount > 0){
                Transaction newTransaction = new Transaction( userDate, userTime, userDescription, userVendor, userAmount);
                transactionList.add(newTransaction);
                addNewTransactionToFile(newTransaction);
                System.out.println("Deposit of " + userAmount + " successfully added to file.");
            }
            else{
                System.out.println("Please enter a positive deposit value.");
            }
        } catch (Exception ex) {
            System.out.println("Please enter a valid input.");
        }

    }

    public void makePayment(){
        System.out.println("To make a payment, please enter the following information.");
        System.out.println("Date (YYYY-MM-DD): ");
        try {
            Scanner mpscanner = new Scanner(System.in);
            LocalDate userDate =LocalDate.parse(mpscanner.nextLine());
            System.out.println("Time (HH:MM:SS): ");
            LocalTime userTime = LocalTime.parse(mpscanner.nextLine());
            System.out.println("Description: ");
            String userDescription = mpscanner.nextLine();
            System.out.println("Vendor: ");
            String userVendor = mpscanner.nextLine();
            System.out.println("Payment Amount: ");
            double userAmount = mpscanner.nextDouble();
            if(userAmount < 0.00 ){
                Transaction newTransaction = new Transaction(userDate, userTime, userDescription, userVendor, userAmount);
                transactionList.add(newTransaction);
                addNewTransactionToFile(newTransaction);
                System.out.println("Payment of " + userAmount + " successfully added to file.");
            }
            else{
                System.out.println("Please enter a negative payment value.");
            }
        } catch (Exception ex) {
            System.out.println("Please enter a valid input.");
        }

    }



}