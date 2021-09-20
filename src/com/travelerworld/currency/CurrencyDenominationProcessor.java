package com.travelerworld.currency;

import java.util.HashMap;

public class CurrencyDenominationProcessor {
    public static HashMap<Integer, Integer> processRequiredAmount(int targetAmount, CurrencyDenomination currencyDenomination) {
        HashMap<Integer, Integer> requiredCurrencyDenominations = new HashMap<>();
        int[] currencyDenominations = currencyDenomination.getCurrencyDenominations();
        int processAmount = targetAmount;
        int reminder = 0;
        for (int i = 0; i < currencyDenominations.length; i++) {
            if (currencyDenominations[i] > processAmount) {
                continue;
            } else {
                int noteCount = processAmount / currencyDenominations[i];
                requiredCurrencyDenominations.put(currencyDenominations[i], noteCount);
                reminder = processAmount % currencyDenominations[i];
                if (reminder == 0) {
                    break;
                } else {
                    processAmount = reminder;
                }
            }
        }
        if (reminder > 0) {
            System.out.println("Amount: " + targetAmount + " couldn't be paid with provided below denominations: ");
            currencyDenomination.printCurrencies();
            return null;
        }
        return requiredCurrencyDenominations;
    }
}
