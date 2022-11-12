package com.ailpha.practice.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 幽灵引用代码示例
 * @author andy
 */
public class PhantomReferenceDemo {

    private static Logger logger = LoggerFactory.getLogger(PhantomReferenceDemo.class);

    public static void main(String[] args) throws Exception{

        // 对象初始化
        String str = new String("PhantomReference");

        // 引用队列
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        // 幽灵引用
        PhantomReference<String> ref = new PhantomReference<>(str,referenceQueue);
        logger.info("引用队列的对象情况：{}", referenceQueue.poll());

        // 垃圾回收
        System.gc();
        logger.info("垃圾回收后的引用队列的对象情况：{}", referenceQueue.poll());
    }

}
