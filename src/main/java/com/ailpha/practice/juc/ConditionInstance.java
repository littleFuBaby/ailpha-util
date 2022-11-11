package com.ailpha.practice.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConditionInstance {

	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		lock.lock(); // ��������������ᱨ��IllegalMonitorStateException
		try {
			new Thread(() -> {
				try {
					lock.lock(); // �ٴ�ϸ�ֵ��̣߳���Ҫ���������򱨳�IllegalMonitorStateException
					condition.signal();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}).start();
			condition.await(); // �ȴ�����
			System.out.println("++++��ȷ����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
