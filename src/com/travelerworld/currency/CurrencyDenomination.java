package com.travelerworld.currency;

public class CurrencyDenomination {
    private int[] currencyDenominations;

    public int[] getCurrencyDenominations() {
        return currencyDenominations;
    }

    public void setCurrencyDenominations(int[] currencyDenominations) {
        this.currencyDenominations = currencyDenominations;
    }

    public void sortDenominations() {
        int left = 0;
        int right = currencyDenominations.length;
        sort(currencyDenominations, left, right);
        System.out.println(currencyDenominations);
    }

    private void sort(int[] denominations, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(currencyDenominations, left, mid);
            sort(currencyDenominations, mid + 1, right);
            merge(currencyDenominations, left, mid, right);
        }
    }

    private void merge(int[] denominations, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++)
            leftArray[i] = denominations[left + i];

        for (int i = 0; i < n1; i++)
            rightArray[i] = denominations[mid + 1 + i];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] >= rightArray[j]) {
                denominations[k] = leftArray[i];
                i++;
            } else {
                denominations[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            denominations[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            denominations[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
