package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class LedgerManager {

    TransactionManager transactionManager= new TransactionManager();
    ArrayList<Transaction> transactionList;

    static void displayAllEntries(ArrayList<Transaction> transactionList){
        transactionList.sort(Comparator.comparing(Transaction::getDate).reversed());
        for(Transaction transaction: transactionList){
            System.out.println(transaction);
        }
    }

    static void displayDeposits(ArrayList<Transaction> transactionList){
        transactionList.sort(Comparator.comparing(Transaction::getDate).reversed());
        boolean hasDeposits= false;
        for(Transaction transaction: transactionList){
           if(transaction.getAmount() > 0){
               System.out.println(transaction);
               hasDeposits= true;
           }
           }
        if(!hasDeposits){
            System.out.println("No Deposits to show.");
        }
    }

    static void displayPayments(ArrayList<Transaction> transactionList){
        transactionList.sort(Comparator.comparing(Transaction::getDate).reversed());
        boolean hasPayments = false;
        for(Transaction transaction: transactionList){
            if(transaction.getAmount() < 0){
                System.out.println(transaction);
                hasPayments= true;
                         }
            }
        if(!hasPayments){
            System.out.println("No Payments to show.");
        }

    }





}
