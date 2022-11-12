package com.ailpha.practice.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 强引用代码示例
 * @author andy
 */
public class StrongReferenceDemo {

    private static Logger logger = LoggerFactory.getLogger(StrongReferenceDemo.class);

    public static void main(String[] args) {
        // 对象声明
        Object object = new Object();

        // 垃圾回收前对象日志打印
        logger.info("垃圾回收前对象日志打印：{}", object);

        // 执行垃圾回收
        System.gc();

        // 垃圾回收后进行对象日志打印
        // 打印结果显示对象依然存在
        logger.info("垃圾回收后进行对象日志打印：{}", object);

    }
}
