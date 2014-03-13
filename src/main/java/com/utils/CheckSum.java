package com.utils;

public class CheckSum {
    public static CheckSum of(String accountNo) {
        int checksum = 0;
        int accountNumber = Integer.valueOf(accountNo);

        for (int i = 1; accountNumber != 0; i++) {
            checksum += (accountNumber % 10) * i;
            accountNumber /= 10;
        }

        return new CheckSum(checksum);
    }

    private int checksum;

    public boolean isValid() {
        return this.checksum % 11 == 0;
    }

    private CheckSum(int checksum) {
        this.checksum = checksum;
    }
}