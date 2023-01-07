package com.ailpha.practice.greedy;

public class GreedyTest {

    public static void main(String[] args) {
        int[] nums = {5207,5594,477,6938,8010,7606,2356,6349,3970,751,5997,6114,9903,3859,6900,7722,2378,1996,8902,228,4461,90,7321,7893,4879,9987,1146,8177,1073,7254,5088,402,4266,6443,3084,1403,5357,2565,3470,3639,9468,8932,3119,5839,8008,2712,2735,825,4236,3703,2711,530,9630,1521,2174,5027,4833,3483,445,8300,3194,8784,279,3097,1491,9864,4992,6164,2043,5364,9192,9649,9944,7230,7224,585,3722,5628,4833,8379,3967,5649,2554,5828,4331,3547,7847,5433,3394,4968,9983,3540,9224,6216,9665,8070,31,3555,4198,2626,9553,9724,4503,1951,9980,3975,6025,8928,2952,911,3674,6620,3745,6548,4985,5206,5777,1908,6029,2322,2626,2188,5639};
        int x = 565610;
        System.out.println("程序运行结果：" + minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {

        int left = 0, right = nums.length - 1;
        int temp = x;
        int num = 0;
        while (left <= right) {
            if (nums[left] > temp && nums[right] > temp) {
                System.out.println("当前 x 的数值：" + temp);
                System.out.println("最左边值索引：" + left + " --- 最右边值索引：" + right);
                System.out.println("最左边值：" + nums[left] + " --- 最右边值：" + nums[right]);
                return -1;
            }
            if (nums[left] > temp && nums[right] <= temp) {
                temp -= nums[right--];
                num++;
                if (isZero(temp)) {
                    return num;
                }
                continue;
            }
            if (nums[right] > temp && nums[left] <= temp) {
                temp -= nums[left++];
                num++;
                if (isZero(temp)) {
                    return num;
                }
                continue;
            }
            // left 和 right 同时比 temp 小
            if (nums[left] >= nums[right]) {
                temp -= nums[left++];
            } else {
                temp -= nums[right--];
            }
            num++;
            if (isZero(temp)) {
                return num;
            }
        }
        return temp == 0 ? num : -1;
    }

    public static boolean isZero (int x) {
        return x == 0;
    }

}
