package org.example;

import jdk.jfr.StackTrace;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TransactionManager {
    public ArrayList<Transaction> LoadTransactions() {

        ArrayList<Transaction> transactionList= new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
            Scanner scanner = new Scanner(fileInputStream);
            scanner.nextLine();
            String input;
            while(scanner.hasNextLine()){
                input= scanner.nextLine();
                String[] rowArray = input.split("\\|");

                Transaction transaction = new Transaction(rowArray[0], rowArray[1], rowArray[2], rowArray[3], Double.parseDouble(rowArray[4]));

                transactionList.add(transaction);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("Could not locate file.");
        }
        return transactionList;

    }

    public void CreateNewTransaction(Transaction transaction){
        //make a instance where you cant add transaction unless account balance is greater or equal to amount of purchase (sum of balance + amount >= 0)
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            String newTransaction = transaction.toString();

            fileWriter.write(newTransaction);
            fileWriter.close();

        }
        catch(IOException ex){
            System.out.println("Could not create new Transaction.");
        }
    }
}