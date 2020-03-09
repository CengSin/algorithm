package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 可被5整除的2进制前缀
 * @author: 15262
 * @date: 2020/3/9
 */

class LeetCode_1018_Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int num = 0;

        for (int i = 0; i < A.length; i++) {
            num = (num << 1 | A[i]) % 10;
            ans.add(num == 0 || num == 5);
        }
        return ans;
    }
}

public class LeetCode_1018_BinaryPrefixDivisibleBy5 {

    public static void main(String[] args) {
        LeetCode_1018_Solution solution = new LeetCode_1018_Solution();
        System.out.println(solution.prefixesDivBy5(new int[]{0, 1, 1}));
        System.out.println(solution.prefixesDivBy5(new int[]{1, 1, 1}));
        System.out.println(solution.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
        System.out.println(solution.prefixesDivBy5(new int[]{1, 1, 1, 0, 1}));
    }

}
