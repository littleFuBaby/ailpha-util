package com.ailpha.test;

public class Test {

    public static void main(String[] args) {

        String[] str1 = "234233".split("(()+)|");
        System.out.println(str1.length);
        for (String s : str1) {
            System.out.print(s + " =");
        }

        String[] str = "abcdfifjabcabcdfkabcabckgflh".split("(abc)+");

        System.out.println(str.length);

        String[] strings1 = "123".split("\\d+");
        System.out.println(strings1.length);

        //String[] strings = "abbcccaa".split("[a-z]*");
        String[] strings = "abbcccaa".split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        System.out.println(strings.length);
        for (String s : strings) {
            System.out.print(s + " ");
        }


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
                //sum += sum(s.substring(head, tail));
                sum += sum2(tail - head);
                head = tail;
                continue;
            }
            if (tail == s.length() - 1) {
                //sum += sum(s.substring(head));
                sum += sum2(tail - head + 1);
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

    public static long sum2(int num) {
        int a1 = 1;
        int d = 1;
        return num * a1 + num * (num - 1) * d / 2;
    }


}
