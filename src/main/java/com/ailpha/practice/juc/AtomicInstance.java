package com.ailpha.practice.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

class AtomicModel {
	
	public static int count = 0;
	
	private volatile long id;
	private String info;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public AtomicModel(long id, String info) {
		super();
		this.id = id;
		this.info = info;
		count ++;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void changeId(long newId){
		// ʹ��AtomicLongFieldUpdater��
		AtomicLongFieldUpdater alfu = AtomicLongFieldUpdater.newUpdater(this.getClass(), "id");
		alfu.compareAndSet(this, this.id, newId);
	}
	
	@Override
	public String toString() {
		return "AtomicModel [id=" + id + ", info=" + info + "]";
	}
}

public class AtomicInstance {

	public static void main(String[] args) {
		// AtomicLong
		AtomicLong al = new AtomicLong(99);
		System.out.println("initial value:" + al);
		al.incrementAndGet();
		System.out.println("incrementAndGet value:" + al);
		al.decrementAndGet();
		System.out.println("decrementAndGet value:" + al);
		al.compareAndSet(99, 200);
		System.out.println("compareAndSet value:" + al);
		
		// AtomicReference
		AtomicModel am1 = new AtomicModel(100, "demo");
		AtomicModel am2 = new AtomicModel(200, "change");
		AtomicReference<AtomicModel> ar = new AtomicReference<AtomicModel>(am1);
		System.out.println("init reference --> " + ar);
		ar.compareAndSet(am2, am2);
		System.out.println("first change reference --> " + ar.get());
		ar.compareAndSet(am1, am2);
		System.out.println("second change reference --> " + ar.get());
		
		System.out.println("first Total count:" + AtomicModel.count);
		
		AtomicInteger ai = new AtomicInteger(AtomicModel.count);
		
		// AtomicLongFieldUpdater
		AtomicModel am = new AtomicModel(100, "okay");
		System.out.println("Atomic model before:" + am);
		am.changeId(110);
		System.out.println("Atomic model end:" + am);
		
		System.out.println("second Total count:" + AtomicModel.count);
		
		System.out.println("before second Total count:" + ai.get());
		
	}

}
