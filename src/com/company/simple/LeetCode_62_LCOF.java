package com.company.simple;

import javafx.geometry.Side;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 圆圈中最后剩下的数字
 * @author: 15262
 * @date: 2020/3/30
 */
class LeetCode_62_Solution {
    public int lastRemaining(int n, int m) {
        // 使用数组模拟每次删除的次数
//        return arrayImpl(n, m);
        // 数学公式（反推）
        return math(n, m);
    }

    private int math(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    private int arrayImpl(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

}

public class LeetCode_62_LCOF {

    public static void main(String[] args) {
        LeetCode_62_Solution solution = new LeetCode_62_Solution();
        System.out.println(solution.lastRemaining(5, 3));
        System.out.println(solution.lastRemaining(10, 17));
    }

}
