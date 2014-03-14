package com.utils;

public class CheckSum {
    public static CheckSum of(Integer accountNumber) {
        int checksum = 0;

        for (int i = 1; accountNumber != 0; i++) {
            checksum += (accountNumber % 10) * i;
            accountNumber /= 10;
        }

        return new CheckSum(checksum);
    }

    private final int checksum;

    private CheckSum(int checksum) {
        this.checksum = checksum;
    }

    public boolean isValid() {
        return this.checksum % 11 == 0;
    }
}
