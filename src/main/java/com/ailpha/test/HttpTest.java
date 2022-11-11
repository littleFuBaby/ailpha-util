package com.ailpha.test;

import com.ailpha.common.util.HttpUtil;

public class HttpTest {

    public static void main(String[] args) {
        String url = "https://blog.csdn.net/csdn_fys/article/details/105711420";
        String url2 = "https://xie.infoq.cn/article/70da6cde668a9c022f9190b87";

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("begin");
            String res = HttpUtil.sendGet(url);
            System.out.println(res);
            String res2 = HttpUtil.sendGet(url2);
            System.out.println(res2);
            System.out.println("end");
        }
    }


}
