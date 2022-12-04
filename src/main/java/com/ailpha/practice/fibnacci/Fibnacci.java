package com.ailpha.practice.fibnacci;

/**
 *
 */
public class Fibnacci {

    /**
     * stupid recursion method
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * use array to store calculating number
     * @param n
     * @param array
     * @return
     */
    public static int fib2(int n, int[] array) {
        if (n <= 1) {
            return n;
        }
        if (array[n] == 0) {
            array[n] = fib2(n - 1, array) + fib2(n - 2, array);
        }
        return array[n];
    }

    /**
     * use for loop
     * @param n
     * @return
     */
    public static int fib3(int n) {
        int[] array = new int[n + 1];
        array[1] = 1;
        for(int i=2; i<=n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static void main(String[] args) {
        int n = 40;
        // fib1
        long now = System.currentTimeMillis();
        System.out.println(fib1(n));
        System.out.println(System.currentTimeMillis() - now);

        // fib2
        now = System.currentTimeMillis();
        System.out.println(fib2(n, new int[n + 1]));
        System.out.println(System.currentTimeMillis() - now);

        // fib3
        now = System.currentTimeMillis();
        System.out.println(fib3(n));
        System.out.println(System.currentTimeMillis() - now);
    }


}
