package com.company.simple;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 按既定顺序创建目标数组
 * @author: 15262
 * @date: 2020/3/23
 */

class LeetCode_1389_Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (Integer integer : list) {
            result[k++] = integer;
        }
        return result;
    }
}

public class LeetCode_1389_CreateTargetArrayGivenOrder {

    public static void main(String[] args) {
        LeetCode_1389_Solution solution = new LeetCode_1389_Solution();
        System.out.println(Arrays.toString(solution.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
    }

}
