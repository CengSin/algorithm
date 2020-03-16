package com.company.simple;

import java.util.Arrays;

/**
 * @description: 比较字符串中最小字母出现频次
 * @author: 15262
 * @date: 2020/3/16
 */

class LeetCode_1170_Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // answer[i] 满足 f(queries[i]) < f(w)的词的数据， W是词汇表Words中的词

        int[] answer = getAns(queries);

        int[] wordAns = getAns(words);

        Arrays.sort(wordAns);

        int[] ans = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            int l = 0;
            int r = wordAns.length - 1;

            while (l < r) {
                int mid = (l + r) / 2;
                if (wordAns[mid] <= answer[i]) l = mid + 1;
                else r = mid;
            }

            if (wordAns[l] <= answer[i]) {
                ans[i] = 0;
            } else {
                ans[i] = (wordAns.length - r);
            }
        }

        return ans;
    }

    private int[] getAns(String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = f(queries[i]);
        }
        return answer;
    }

    private int f(String query) {
        // 拿到字符串中最小的字符
        char minChar = 'z';
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) < minChar) {
                minChar = query.charAt(i);
            }
        }

        int count = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == minChar) {
                count ++;
            }
        }

        return count;
    }
}

public class LeetCode_1170_CompareStringsByFrequencyOfSmallestCharacter {

    public static void main(String[] args) {
        LeetCode_1170_Solution solution = new LeetCode_1170_Solution();
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
    }

}
