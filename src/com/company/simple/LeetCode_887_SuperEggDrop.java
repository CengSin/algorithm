package com.company.simple;

import java.util.Arrays;

/**
 * 887. 鸡蛋掉落
 */
class LeetCode_887_Solution {

    /**
     * 鸡蛋掉落，鹰蛋（Leetcode 887）：（经典dp）
     * 有 K 个鸡蛋，有 N 层楼，用最少的操作次数 F 检查出鸡蛋的质量。
     *
     * 思路：
     * 本题应该逆向思维，若你有 K 个鸡蛋，你最多操作 F 次，求 N 最大值。
     *
     * dp[k][f] = dp[k][f-1] + dp[k-1][f-1] + 1;
     * 解释：
     * 0.dp[k][f]：如果你还剩 k 个蛋，且只能操作 f 次了，所能确定的楼层。
     * 1.dp[k][f-1]：蛋没碎，因此该部分决定了所操作楼层的上面所能容纳的楼层最大值
     * 2.dp[k-1][f-1]：蛋碎了，因此该部分决定了所操作楼层的下面所能容纳的楼层最大值
     * 又因为第 f 次操作结果只和第 f-1 次操作结果相关，因此可以只用一维数组。
     *
     * 时复：O(K*根号(N))
     */
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;    // 操作的次数
        while (dp[K] < N){
            for (int i = K; i > 0; i--) // 从后往前计算
                dp[i] = dp[i] + dp[i-1] + 1;
            ans++;
        }
        return ans;
    }

    public int superEggDropDp(int K, int N) {
        if (K == 1) return N;

        // 二维数组表示楼层数量
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], 999999);
        }

        // 初始化 当只有一个鸡蛋的时候，每层楼的最坏取值
        for (int i = 1; i < N + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 当只有一层楼的时候，他的最坏取值只有1
        for (int i = 0; i < K + 1; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        // 求解
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // 二分查找寻找k的最优取值 最小的值
                int left = 1;
                int right = i;

                while (left < right) {
                    int mid = left + (right - left + 1) / 2;

                    int eggsBreak = dp[mid - 1][j - 1];
                    int notEggsBreak = dp[i - mid][j];

                    if (eggsBreak > notEggsBreak) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }

                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }

        return dp[N][K];
    }

    /**
     * O(KN*N)N*N表示最坏的情况下初始最优t楼层的取值需要循环N遍才能找到
     *
     * @param K 鸡蛋的个数
     * @param N 楼层
     * @return 最少次数
     */
    public int superEggDropTimeOut(int K, int N) {
        if (K == 1) return N;

        // 二维数组 行表示楼层数量 列表示鸡蛋个数
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(dp[i], 9999);
        }

        // 初始化 当鸡蛋只有一个的时候，不同楼层的最坏的测试次数
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 初始化 当只有一层楼的时候，K个鸡蛋的最坏测试次数
        for (int i = 1; i <= K; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        // 当有K个鸡蛋，N层楼的时候，
        // 如果选择第t层扔第1个鸡蛋，那么在最坏情况下，func_t(K, N) = Max(func_t(K-1, t-1), func_t(k, n- t)) + 1
        // 根据t选择的层数，我们要选最坏情况下仍的最少次数 fun(K, N) = Min(Max(func_t_1, func_t_2, .... func_t_n))

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // 这里使用 二分查找 优化 k的取值
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                }
            }
        }

        // 去找 N 层楼那一列的最小值
        return dp[N][K];
    }

}

public class LeetCode_887_SuperEggDrop {

    public static void main(String[] args) {
        LeetCode_887_Solution solution = new LeetCode_887_Solution();
        System.out.println(solution.superEggDrop(1, 2));
        System.out.println(solution.superEggDrop(2, 6));
        System.out.println(solution.superEggDrop(3, 14));
    }

}
