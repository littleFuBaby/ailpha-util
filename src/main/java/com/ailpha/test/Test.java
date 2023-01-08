package com.ailpha.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {

        int[] nums = {672579538,806947365,854095676,815137524};
        int k = 3;
        System.out.println(maxKelements(nums, 3));

        Map<Object, Object> map = new Hashtable<>();
        map = new HashMap<>();
        map = new ConcurrentHashMap<>();

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

    public static long maxKelements(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        for (int i=0; i<k; i++) {
            //Arrays.sort(nums);
            int j = 0;
            int max= 0;
            int maxIndex = 0;
            while (j < nums.length) {
                if (nums[j] > max) {
                    max = nums[j];
                    maxIndex = j;
                }
                j++;
            }
            //sum += nums[n - 1];
            sum += nums[maxIndex];
            double c = nums[maxIndex];
            double d = Math.ceil(c / 3);
            int e =  (int) d;
            nums[maxIndex] = e;
        }
        return sum;
    }

    public static long maxKelements2(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        for (int i=0; i<k; i++) {
            Arrays.sort(nums);
            sum += nums[n - 1];
            double c = nums[n - 1];
            double d = Math.ceil(c / 3);
            int e =  (int) d;
            nums[n - 1] = e;
        }
        return sum;
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
