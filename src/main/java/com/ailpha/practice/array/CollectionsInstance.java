package com.ailpha.practice.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsInstance {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("fu", "0098");
        map.put("yun", "009");
        map.put("song", "00");
        System.out.println(map);

        Map<String, String> newMap = Collections.singletonMap("fuyunsong", "0000");
        System.out.println(newMap);
    }

}

