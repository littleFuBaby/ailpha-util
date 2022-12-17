package com.ailpha.practice.string;

public class StringTest {

    public static void main(String[] args) {
        String str = "df2321afdsdfdf23423sdf";
        String[] array = str.split("[a-z]+");
        for (String s : array) {
            System.out.println(s);
        }

        str = "abc";
        for (int i=0; i<str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        for (char ch : str.toCharArray()) {
            System.out.println(ch);
        }
    }
}
