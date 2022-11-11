package com.ailpha.practice.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

public class ReferenceTypeInstance {

	public static void main(String[] args) {
		// Strong Reference
		Object obj = new Object();
		Object ref = obj;
		System.out.println(ref);
		System.out.println(obj);
		obj = null;
		System.out.println("***GC***");
		Runtime.getRuntime().gc();
		System.out.println(ref);
		System.out.println(obj);
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		// soft reference
		String soft = new String("soft reference");
		SoftReference<String> softRef = new SoftReference<String>(soft);
		soft = null;
		String temp = "test soft reference";
		try {
			while(true){
				temp += temp + new Random().nextInt(9999999);
				temp.intern();
			}
		} catch (Throwable e) {
		}
		System.out.println(softRef.get() + "******"); 
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		// weak reference
		// WeakHashMap
		String key = new String("fuys");
		String value = new String("0822");
		Map<String, String> map = new WeakHashMap<>();
		map.put(key, value);
		System.out.println(map);
		key = null;
		System.out.println(map);
		System.gc();
		System.out.println(map);
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		// WeakReference
		String str = new String("weak reference");
		WeakReference<String> weakRef = new WeakReference<String>(str);
		System.out.println(weakRef.get());
		str = null;
		System.out.println(weakRef.get());
		System.gc();
		System.out.println(weakRef.get());
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		// reference queue
		String ss = new String("queue");
		ReferenceQueue<String> queue = new ReferenceQueue<>();
		WeakReference<String> weakRefe = new WeakReference<String>(ss, queue);
		System.out.println(weakRefe.get());
		System.out.println(queue.poll());
		ss = null;
		System.gc();
		System.out.println(weakRefe.get());
		System.out.println(queue.poll());
		
		// phantom reference
		String phantom = new String("phantom");
		ReferenceQueue<String> pQueue = new ReferenceQueue<>();
		PhantomReference<String> pRef = new PhantomReference<String>(phantom, pQueue);
		System.out.println(pRef.get());
		System.out.println(pQueue.poll());
		System.gc();
		phantom = null;
		System.out.println(pRef.get());
		System.out.println(pQueue.poll());		
	}

}
