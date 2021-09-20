package com.paymoney.driver;

import com.paymoney.targetprocessing.DailyTargetProcessor;

import java.util.Scanner;

public class PayMoneyTargetDriver {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);

        //Get the Size of Transaction array
        boolean validInput = false;
        int inputSize = 0;
        while (!validInput) {
            System.out.println("Enter the size of transaction array");
            inputSize = input1.nextInt();
            if (inputSize > 0) {
                validInput = true;
            } else {
                System.out.println("Invalid Input size. Try again");
            }
        }

        //Get the transactions
        Scanner input2 = new Scanner(System.in);
        int[] transactions = new int[inputSize];
        String[] transactionValues = null;
        validInput = false;
        while (!validInput) {
            System.out.println("Enter the values of array separated by space");
            String temp = input2.nextLine();
            transactionValues = temp.split(" ");
            if (transactionValues.length > inputSize) {
                System.out.println("You entered more values than provided Input Size: " + inputSize + ". Try again");
            } else if (transactionValues.length < inputSize) {
                System.out.println("You entered less values than provided Input Size: " + inputSize + ". Try again");
            } else {
                validInput = true;
            }
        }
        // Feed values from input to transaction array
        int counter = 0;
        while (counter < inputSize) {
            transactions[counter] = Integer.parseInt(transactionValues[counter]);
            counter++;
        }

        //Get the Target Amount
        System.out.println("Please enter the target amount :");
        int targetAmount = input2.nextInt();

        //Check if target is achieved
        DailyTargetProcessor dailyTargetProcessor = new DailyTargetProcessor();
        int status = dailyTargetProcessor.isTargetAchieved(transactions, targetAmount);
        if (status > 0) {
            System.out.println("Target is achieved after " + status + " transactions");
        } else if (status == 0) {
            System.out.println("Target is not achieved");
        } else {
            System.out.println("Target cannot be achieved");
        }
    }
}
