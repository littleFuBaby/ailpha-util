package com.ailpha.practice.juc;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ConcurrentHashMapInstance {

	public static Map<String, Integer> map = new ConcurrentHashMap<>(20, 10, 30);
	public static CountDownLatch cdl = new CountDownLatch(1000);
	private static Random random = new Random();

	public static void main(String[] args) {
		
		for (int x = 0; x < 1000; x++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					map.put(Thread.currentThread().getName(), random.nextInt(1000));
					cdl.countDown();
				}
			}).start();
		}

		try {
			cdl.await();
			System.out.println(map);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

/*public static final V putVal(K key, V value, boolean onlyIfAbsent) {
    if (key == null || value == null) 
    	throw new NullPointerException();
    
    // �@ȡkey��λ��
    int hash = spread(key.hashCode());
    
    int binCount = 0;
    
    
    // ��v��
    for (Node<K,V>[] tab = table;;) {
    	
    	
        Node<K,V> f; 
        int n, i, fh;
        
        
        // ������գ��t��ʼ���������l
        if (tab == null || (n = tab.length) == 0)
            tab = initTable();
        
        
        
        // ����ָ��keyλ���µĽڵ�
        else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
        	
        	// ƥ�䲢����
            if (casTabAt(tab, i, null,
                         new Node<K,V>(hash, key, value, null)))
                break;                   // no lock when adding to empty bin
        }
        
        
        // ����ƶ�����ת��
        else if ((fh = f.hash) == MOVED)
            tab = helpTransfer(tab, f);
        else {
        	
        	
            V oldVal = null;
            synchronized (f) {
                if (tabAt(tab, i) == f) {
                	
                    if (fh >= 0) {
                        binCount = 1;
                        for (Node<K,V> e = f;; ++binCount) {
                            K ek;
                            if (e.hash == hash &&
                                ((ek = e.key) == key ||
                                 (ek != null && key.equals(ek)))) {
                                oldVal = e.val;
                                if (!onlyIfAbsent)
                                    e.val = value;
                                break;
                            }
                            
                            
                            
                            Node<K,V> pred = e;
                            
                            
                            
                            if ((e = e.next) == null) {
                                pred.next = new Node<K,V>(hash, key,
                                                          value, null);
                                break;
                            }
                        }
                    }
                    else if (f instanceof TreeBin) {
                        Node<K,V> p;
                        binCount = 2;
                        if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                       value)) != null) {
                            oldVal = p.val;
                            if (!onlyIfAbsent)
                                p.val = value;
                        }
                    }
                }
            }
            
            
            
            
            if (binCount != 0) {
                if (binCount >= TREEIFY_THRESHOLD)
                    treeifyBin(tab, i);
                if (oldVal != null)
                    return oldVal;
                break;
            }
        }
    }
    
    
    addCount(1L, binCount);
    return null;
}*/