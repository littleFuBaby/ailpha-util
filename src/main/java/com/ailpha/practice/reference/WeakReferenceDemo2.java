package com.ailpha.practice.reference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.WeakReference;

/**
 * 弱引用代码示例
 * @author andy
 *
 */
public class WeakReferenceDemo2 {

    private static Logger logger = LoggerFactory.getLogger(WeakReferenceDemo2.class);

    public static void main(String[]atgs){

        // 对象初始化
        String str = new String("weakReference");

        // 使用 WeakReference 类实现弱引用
        WeakReference<String> weakReference = new WeakReference<>(str);
        logger.info("弱引用的对象情况：{}", weakReference.get());

        // 对象赋值为空，解除强引用
        str = null;
        logger.info("垃圾回收前的弱引用的对象情况：{}", weakReference.get());

        // 垃圾回收
        System.gc();
        logger.info("垃圾回收后的弱引用的对象情况：{}", weakReference.get());

        // 延伸思考，new String()和直接赋值，结果是否相同？
        // String str = "weakReference";
    }

}
