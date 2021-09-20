package com.paymoney.targetprocessing;

public class DailyTargetProcessor {

    public int isTargetAchieved(int[] transactions, int target) {
        //Negative targets can't be achieved
        if (target < 0) {
            return -1;
        }

        //Check if target is achieved
        int sum = 0;
        for (int i = 0; i < transactions.length; i++) {
            sum = sum + transactions[i];
            if (sum >= target) {
                return i + 1;
            }
        }
        return 0;
    }
}
