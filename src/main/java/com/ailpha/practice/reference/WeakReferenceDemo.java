package com.ailpha.practice.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * 弱引用代码示例
 * @author andy
 */
public class WeakReferenceDemo {

    private static Logger logger = LoggerFactory.getLogger(WeakReferenceDemo.class);

    public static void main(String[] args) {

        // 初始化对象
        String key = new String("stack");
        String value = "heap";

        // 弱引用使用 WeakHashMap 类实现
        Map<String,String> weakReference = new WeakHashMap<>();
        weakReference.put(key,value);

        // 垃圾回收前的对象情况
        logger.info("弱引用的对象情况：{}",weakReference);

        // 对key进行赋值为 null
        key = null;
        logger.info("垃圾回收前的弱引用的对象情况：{}",weakReference);

        // 垃圾回收查看弱引用对象情况
        System.gc();
        logger.info("垃圾回收后的弱引用的对象情况：{}",weakReference);

        // 延伸思考，new String()和直接赋值结果是否相同？
        // String key = "stack";
        // String value = "heap";

    }

}
