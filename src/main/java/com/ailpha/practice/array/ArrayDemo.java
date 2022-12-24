package com.ailpha.practice.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {

    public static void main(String[] args) {
        //int[] forts = new int[]{1,0,0,-1,0,0,0,0,1};
        //System.out.println(captureForts(forts));
        System.out.println(minimizeSet(2,7,1,3));
        System.out.println(minimizeSet(3,5,2,1));
        System.out.println(minimizeSet(2,4,8,2));
    }


    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int index = 1;
        int num = 0;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        while (num < uniqueCnt1 + uniqueCnt2) {
            if (index % divisor1 != 0 && arr1.size() < uniqueCnt1) {
                arr1.add(index);
                num++;
            } else if (index % divisor2 != 0 && arr2.size() <= uniqueCnt2) {
                arr2.add(index);
                num++;
            }
            index++;
        }
        System.out.println(arr1.size() + " " + arr2.size());
        return Math.max(arr1.get(uniqueCnt1 - 1), arr2.get(uniqueCnt2 - 1));
    }

    public static int captureForts(int[] forts) {
        int preIndex = -1;
        int preMax = 0;
        for (int i=0; i<forts.length; i++) {
            int num = forts[i];
            if (num == 1 && preIndex == -1) {
                preIndex = i;
            } else if (num == -1 && preIndex != -1) {
                preMax = Math.max(preMax, i - preIndex - 1);
                preIndex = -1;
            }
        }
        int postIndex = -1;
        int postMax = 0;
        for (int j=forts.length - 1; j>=0; j--) {
            int num = forts[j];
            if (num == 1 && postIndex == -1) {
                postIndex = j;
            } else if (num == -1 && postIndex != -1) {
                postMax = Math.max(postMax, postIndex - j - 1);
                postIndex = -1;
            }
        }
        return Math.max(preMax, postMax);
    }

}
