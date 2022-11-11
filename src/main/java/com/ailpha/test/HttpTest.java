package com.ailpha.test;

import com.ailpha.common.util.HttpUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class HttpTest {

    public static void main(String[] args) {
        String url = "https://blog.csdn.net/csdn_fys/article/details/105711420";
        String url2 = "https://xie.infoq.cn/article/70da6cde668a9c022f9190b87";

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("test", "test");
        map.put("test1", "test1");
        map.put("test2", "test2");
        Set<String> set = map.keySet();
        System.out.println(set);

//        for (int i = 0; i < 10; i++) {
//            try {
//
//                Thread.sleep(2000);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//            System.out.println("begin");
//            String res = HttpUtil.sendGet(url);
//            System.out.println(res);
//            String res2 = HttpUtil.sendGet(url2);
//            System.out.println(res2);
//            System.out.println("end");
//        }
    }


}

