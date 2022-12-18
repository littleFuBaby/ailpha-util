package com.ailpha.practice.string;

import java.util.HashMap;
import java.util.Map;

public class StringTest2 {

    public static void main(String[] args) {
        String[] words = new String[]{"aba","aabb","abcd","bac","aabc"};
        System.out.println(similarPairs(words));
        words = new String[]{"aabb","ab","ba"};
        System.out.println(similarPairs(words));
        words = new String[]{"nba","cba","dba"};
        System.out.println(similarPairs(words));
    }

    public static int similarPairs(String[] words) {
        int res = 0;
        for (int i=0; i<words.length - 1; i++) {
            Map<Character,Object> map = new HashMap<>();
            for (int k=0; k<words[i].length(); k++) {
                map.put(words[i].charAt(k), null);
            }
            for (int j=i+1; j<words.length; j++) {
                Map<Character,Object> map2 = new HashMap<>();
                for (int l=0; l<words[j].length(); l++) {
                    if (map.containsKey(words[j].charAt(l)) == false) {
                        break;
                    }
                    map2.put(words[j].charAt(l), null);
                    if (l == words[j].length() - 1) {
                        if (map.size() != map2.size()) {
                            break;
                        }
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
