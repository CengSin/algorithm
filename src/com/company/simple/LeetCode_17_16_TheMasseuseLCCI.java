package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/2/29
 */

class LeetCode_17_16_Solution {
    public int massage(int[] nums) {
        int pre = 0;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            int tmp = cur;

            cur = Math.max(pre + nums[i], cur);

            pre = tmp;
        }

        return cur;
    }
}

public class LeetCode_17_16_TheMasseuseLCCI {

    public static void main(String[] args) {
        LeetCode_17_16_Solution solution = new LeetCode_17_16_Solution();
        System.out.println(solution.massage(new int[]{1, 2, 3, 1}));
        System.out.println(solution.massage(new int[]{2,7,9,3,1}));
        System.out.println(solution.massage(new int[]{2,1,4,5,3,1,1,3}));
    }

}
