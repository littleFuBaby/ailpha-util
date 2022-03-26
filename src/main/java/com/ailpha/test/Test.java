package com.ailpha.test;

public class Test {

    public static void main(String[] args) {
        System.out.println(countHomogenous("z"));
        System.out.println(countHomogenous("zzzzz"));
        System.out.println(countHomogenous("xy"));
        System.out.println(countHomogenous("abbcccaa"));
    }

    public static int countHomogenous(String s) {

        long sum = 0;
        int head = 0, tail = 0;
        while (head < s.length() && tail < s.length()) {
            if (s.charAt(head) != s.charAt(tail)) {
                sum += sum(s.substring(head, tail));
                head = tail;
                continue;
            }
            if (tail == s.length() - 1) {
                sum += sum(s.substring(head));
                break;
            }
            tail++;
        }

        return (int) (sum % (Math.pow(10, 9) + 7));
    }

    public static long sum(String str) {
        long sum = 0;
        int n = 0;
        while (n < str.length()) {
            sum += str.length() - n;
            n++;
        }
        return sum;
    }


}
