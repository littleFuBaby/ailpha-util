package com.ailpha.test;

/**
 * Tunured CMS Garbage Collection Strategy
 * @author andy
 */
public class TunuredCMS {

    public static void main(String[] args) {
        String str = "Tunured CMS";
        while(true){
            str += str;
            str.intern();
        }
    }

}
