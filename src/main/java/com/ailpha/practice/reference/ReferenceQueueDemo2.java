package com.ailpha.practice.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueDemo2 {

    public static void main(String[]atgs) throws Exception{
        String obj = new String("referenceQueue");
        // new String()和直接賦值的區別
        //String obj = "referenceQueue";
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        WeakReference<String> ref = new WeakReference<>(obj,queue);
        System.out.println(queue.poll());
        obj = null;
        System.out.println(queue.poll());
        System.gc();
        Thread.sleep(100);
        System.out.println(queue.poll());
    }

}
