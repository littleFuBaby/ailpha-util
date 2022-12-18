package com.ailpha.practice.number;

public class NumberTest {

    public static void main(String[] args) {
        System.out.println(primeCount(4));
    }

    public static int primeCount(int num) {

        if (isPrime(num) || num == 4) {
            return num;
        }

        int plus = 0;
        int minNumber = 2;// 定义最小的质数
        while (minNumber < num) {
            if (num % minNumber == 0) {
                num = num / minNumber;
                plus += minNumber;
            } else {
                minNumber++;
            }
        }
        plus += minNumber;

        return primeCount(plus);
    }

    public static boolean isPrime(int n) {
        //如果n被i整除，则返回false
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;    // 反之则返回true
    }

}
