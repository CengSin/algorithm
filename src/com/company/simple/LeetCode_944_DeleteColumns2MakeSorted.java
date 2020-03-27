package com.company.simple;

/**
 * @description: 删除造序
 * @author: 15262
 * @date: 2020/3/27
 */

class LeetCode_944_Solution {

    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 0) return 0;
        // 列遍历
        int D = 0;
        int columnLen = A[0].length();
        for (int i = 0; i < columnLen; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    D++;
                    break;
                }
            }
        }
        return D;
    }

}

public class LeetCode_944_DeleteColumns2MakeSorted {

    public static void main(String[] args) {
        LeetCode_944_Solution solution = new LeetCode_944_Solution();
        System.out.println(solution.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        System.out.println(solution.minDeletionSize(new String[]{"a", "b"}));
        System.out.println(solution.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
    }

}
