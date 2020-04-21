package com.company.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计优美子数组
 */
class LeetCode_1248_Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        // 统计出nums的前缀数组
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1); // 当[0, sum[i]]之间有k个奇数时，有一种
        for (int num : nums) {
            sum += (num & 1);
            if (sum >= k) {  // sum >= k 表示奇数的个数大于等于k个了(连续子数组)
                int j = sum - k;
                res += map.get(j);// map中存储的是有几对(j, sum)之间的值==k
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

}

public class LeetCode_1248_CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        LeetCode_1248_Solution solution = new LeetCode_1248_Solution();
        System.out.println(solution.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }

}
