package com.ailpha.practice.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo2 {
    public static void main(String[]atgs){
        String obj = "SoftReference";
        SoftReference<String> ref = new SoftReference<>(obj);
        obj = null;
        String str = "garbage";
        try{
            while(true){
                str += "+"+str;
            }
        }catch(Throwable r){}
        System.gc();
        System.out.println(ref.get()+"######");
    }
}
