package com.company.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 解压缩编码列表
 * @author: 15262
 * @date: 2020/3/25
 */

class LeetCode_1313_Solution {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int cnt = nums[i];
            while (cnt > 0) {
                ans.add(nums[i + 1]);
                cnt --;
            }
        }
        int[] res = new int[ans.size()];
        int k = 0;
        for (Integer an : ans) {
            res[k ++] = an;
        }
        return res;
    }

}

public class LeetCode_1313_DecompressRunLengthEncodedList {

    public static void main(String[] args) {
        LeetCode_1313_Solution solution = new LeetCode_1313_Solution();
        System.out.println(Arrays.toString(solution.decompressRLElist(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.decompressRLElist(new int[]{1, 1, 2, 3})));
    }

}
