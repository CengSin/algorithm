package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/4/4
 */

class LeetCode_1002_Solution {

    public List<String> commonChars(String[] A) {
        int[] res = new int[26];
        for (char c : A[0].toCharArray()) {
            res[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a']++;
            }
            // 比较两个字符串中共同出现的字符
            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], temp[j]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (res[i] > 0) {
                String s = (char) (i + 'a') + "";
                for (int j = 0; j < res[i]; j++) {
                    ans.add(s);
                }
            }
        }
        return ans;
    }

}

public class LeetCode_1002_FindCommonCharacters {

    public static void main(String[] args) {
        LeetCode_1002_Solution solution = new LeetCode_1002_Solution();
        System.out.println(solution.commonChars(new String[]{"bella", "label", "roller"}));
    }

}
