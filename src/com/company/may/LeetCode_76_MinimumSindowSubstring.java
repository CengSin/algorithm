package com.company.may;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZeTao Zhang
 * Date: 2020/5/23
 * Time: 10:15
 * Description:
 */

// 滑动窗口
// 思路：首先建立两个游标，一个标识子串的开始下标，一个标识子串的结束位置。
// 初始值：子串的开始位置left = 结束位置right = 0
// 字串的结束位置每次扩大一个位置 right++ 直到包含所有的t中的字母 res = subString(left, right)
// 开始检查子串中是否有更小的包含t中所有字母的子串，left向右边扩展，
class LeetCode_76_Solution {

    private Map<Character, Integer> targetMap = new HashMap<>();
    private Map<Character, Integer> findMap = new HashMap<>();

    public String minWindow(String s, String t) {

        // 首先使用HashMap记录t字符串中每个字符的出现次数
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 定义窗口大小
        int left = 0, right = -1, ansLeft = -1, ansRight = -1;
        int len = Integer.MAX_VALUE;
        int sLen = s.length();

        while (right < sLen) {
            ++right;
            // 把t和s中同时存在的字符放入到findMap中并记录个数
            if (right < sLen && targetMap.containsKey(s.charAt(right))) {
                findMap.put(s.charAt(right), findMap.getOrDefault(s.charAt(right), 0) + 1);
            }

            // 找到包含t中所有字母的s子串，left开始往右移动缩小范围，找最小子串
            while (check() && left <= right) {
                // 缩小子串的范围
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansLeft = left;
                    ansRight = left + len;
                }

                // 缩小子串中和t同时存在的字符数目
                if (targetMap.containsKey(s.charAt(left))) {
                    findMap.put(s.charAt(left), findMap.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }

        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight);

    }

    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = targetMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            if (findMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}

public class LeetCode_76_MinimumSindowSubstring {
}
