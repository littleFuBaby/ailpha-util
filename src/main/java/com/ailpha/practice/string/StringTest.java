package com.ailpha.practice.string;

public class StringTest {

    public static void main(String[] args) {
        String str = "dfa12321afdsdfdf23423sdf";
        String[] array = str.split("[a-z]+");
        for (String s : array) {
            System.out.println(s);
        }
    }
}
