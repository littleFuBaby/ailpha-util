package com.ailpha.practice.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 引用队列代码示例
 * @author andy
 */
public class ReferenceQueueDemo {

    private static Logger logger = LoggerFactory.getLogger(ReferenceQueueDemo.class);

    public static void main(String[]atgs) throws Exception{

        // 对象初始化
        String str = new String("referenceQueue");

        // 引用队列
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        WeakReference<String> ref = new WeakReference<>(str, referenceQueue);

        // 引用队列情况
        logger.info("引用队列的对象情况：{}", referenceQueue.poll());

        // 对象赋值为null
        str = null;
        logger.info("垃圾回收前的引用队列的对象情况：{}", referenceQueue.poll());

        // 垃圾处理
        System.gc();
        Thread.sleep(100);
        logger.info("垃圾回收后的引用队列的对象情况：{}", referenceQueue.poll());

        // 延伸思考，new String()和直接赋值的结果是否相同？
        // String obj = "referenceQueue";
    }

}
