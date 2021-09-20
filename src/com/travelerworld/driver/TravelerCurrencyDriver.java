package com.travelerworld.driver;

import com.travelerworld.currency.CurrencyDenomination;
import com.travelerworld.currency.CurrencyDenominationProcessor;

import java.util.HashMap;
import java.util.Scanner;

public class TravelerCurrencyDriver {
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);

        //Get the Size of Denominations array
        boolean validInput = false;
        int inputSize = 0;
        while (!validInput) {
            System.out.println("Enter the size of currency denominations");
            inputSize = input1.nextInt();
            if (inputSize > 0) {
                validInput = true;
            } else {
                System.out.println("Invalid Input size. Try again");
            }
        }

        //Get the denominations
        Scanner input2 = new Scanner(System.in);
        int[] denominations = new int[inputSize];
        String[] denominationValues = null;
        validInput = false;
        while (!validInput) {
            System.out.println("Enter the currency denominations values separated by space");
            String temp = input2.nextLine();
            denominationValues = temp.split(" ");
            if (denominationValues.length > inputSize) {
                System.out.println("You entered more values than provided Input Size: " + inputSize + ". Try again");
            } else if (denominationValues.length < inputSize) {
                System.out.println("You entered less values than provided Input Size: " + inputSize + ". Try again");
            } else {
                validInput = true;
            }
        }
        // Feed values from input to transaction array
        int counter = 0;
        while (counter < inputSize) {
            denominations[counter] = Integer.parseInt(denominationValues[counter]);
            counter++;
        }

        //Get the Amount Payable
        System.out.println("Enter the amount you want to pay :");
        int amountPayable = input2.nextInt();

        CurrencyDenomination currencyDenomination = new CurrencyDenomination();
        currencyDenomination.setCurrencyDenominations(denominations);
        currencyDenomination.sortDenominations();

        //Process payable amount
        HashMap<Integer, Integer> requiredCurrencyDenominations = CurrencyDenominationProcessor.processRequiredAmount(amountPayable, currencyDenomination);
        System.out.println("Required denominations for " + amountPayable + " are " + requiredCurrencyDenominations);
    }
}
