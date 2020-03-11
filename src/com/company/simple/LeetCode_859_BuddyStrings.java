package com.company.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 亲密字符串
 * @author: 15262
 * @date: 2020/3/11
 */

class LeetCode_859_Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() >= 2) {
            // 有重复的字符直接返回true
            Set<Character> sets = new HashSet<>();
            for (int i = 0; i < A.length(); i++) {
                sets.add(A.charAt(i));
            }
            if (A.equals(B) && A.length() > sets.size()) return true;

            // 判断A，B字符串中不同字符的位数
            int sum = 0;
            int[] indexs = new int[2];
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    try {
                        indexs[sum ++] = i;
                    } catch (Exception e) {
                        return false;
                    }
                }
            }

            if (sum == 2) {
                for (int i = 0; i < indexs.length; i++) {
                    if (A.charAt(indexs[indexs.length - i - 1]) != B.charAt(indexs[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}

public class LeetCode_859_BuddyStrings {

    public static void main(String[] args) {
        LeetCode_859_Solution solution = new LeetCode_859_Solution();
        assert solution.buddyStrings("aaaaaaabc", "aaaaaaacb");
    }

}
