package com.ailpha.practice.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;

/**
 * 软引用代码示例
 * @author andy
 */
public class SoftReferenceDemo {

    private static Logger logger = LoggerFactory.getLogger(SoftReferenceDemo.class);

    public static void main(String[] args) {

        // 初始化对象
        String softReferenceStr = "soft reference";
        SoftReference<String> softReference = new SoftReference<>(softReferenceStr);

        // 为了体现软引用，将 softReferenceStr 赋值为空
        softReferenceStr = null;
        logger.info("垃圾回收前的软引用对象地址：{}", softReference.get());

        // 为了体现软引用被垃圾回收器回收，借助另一个对象进行持续性赋值，最后抛出内存异常错误
        // 这样的情况下，模拟出最后内存不够，进而进行 GC 操作
        String str = "Garbage";
        try {
            while (true) {
                str += str;
            }
        } catch (Throwable e) {
            // 由于内存溢出是Error错误，故而以捕获 Throwable 接口实现类为主
            logger.error("内存溢出异常", e);
        } finally {
            System.gc();
            try {
                // 垃圾回收需要时间，故而等待 10 s
                Thread.sleep(100000);
            } catch (Exception e) {
                logger.error("线程类延时程序异常", e);
            }
            logger.info("软引用垃圾回收处理后对象地址：{}", softReference.get());
        }

    }

}
