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

        String x = "abc";
        String y = new String("abc");

        System.out.println(x == y);

        System.out.println(x.equals(y));

        System.out.println(x.equalsIgnoreCase(y));

        System.out.println(String.valueOf('A' + 32));

        StringBuffer sb = new StringBuffer();
        sb.append('A' + 32);
        System.out.println(sb.toString());

        System.out.println(str.toLowerCase());

        int number = 5; //注意这里数字只能是个位数并且不能为负
        String temp = Integer.toString(number);
        char ch = temp.charAt(0);
        System.out.println("数字转字符："+ch);

    }
}
