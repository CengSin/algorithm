package com.company.simple;

import java.util.Arrays;

class LeetCode_56_I_Solution {

    public int[] singleNumbersNew(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        int mask = 1;

        while ((k & mask) == 0) {
            mask <<= 1; // 找两个数第一个不同的位子
        }

        for (int num : nums) {
            if ((num ^ mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public int[] singleNumbers(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int tmp = nums[i];
            while (j >= 0 && nums[j] >= tmp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }

        int[] res = new int[2];
        int k = 0;
        for (int i = 0; i < nums.length - 1 && k < res.length; ) {
            if (nums[i] != nums[i + 1]) {
                res[k++] = nums[i];
                i++;
            } else {
                i += 2;
                if (i == nums.length - 1) {
                    res[k++] = nums[i];
                }
            }
        }
        return res;
    }
}

public class LeetCode_56_I_LOCF {

    public static void main(String[] args) {
        LeetCode_56_I_Solution solution = new LeetCode_56_I_Solution();
        System.out.println(Arrays.toString(solution.singleNumbers(new int[]{6, 5, 1, 5})));
    }

}
