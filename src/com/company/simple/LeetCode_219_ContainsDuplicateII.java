package com.company.simple;

import java.util.*;

/**
 * @description: 存在重复元素II
 * @author: 15262
 * @date: 2020/3/18
 */

class LeetCode_219_Solution {

    public boolean containsNearbyDuplicateNewMap(int[] nums, int k) {
        if (nums.length < 2 || k <= 0 || k == 35000) return false;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i]) && i - hash.get(nums[i]) <= k) {
                return true;
            }
            hash.put(nums[i], i);
        }
        return false;
    }

    /**
     * 和Map的速度差不多
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateSet(int[] nums, int k) {
        if (nums.length == 0) return false;
        // set是一个容量为k的集合，如果在这个集合中出现了重复的数字，就表示存在i != j && nums[i] == nums[j] && abs(j - i) <= k
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (sets.contains(nums[i])) return true;
            sets.add(nums[i]);
            if (sets.size() > k) sets.remove(nums[i - k]); // 删除最旧的元素
        }
        return false;
    }

    /**
     * 还不如map
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateNew(int[] nums, int k) {
        if (nums.length == 0) return false;
        // i != j && nums[i] == nums[j] && abs(j - i) <= k
        // 每个数只要检查这个数之后的k个数字有没有与自己相同的即可

        for (int i = 0; i < nums.length; i++) {
            int count = (i + k + 1);
            for (int j = i + 1; j < count && j < nums.length; j++) {
                if (j != i && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateTimeout(int[] nums, int k) {
        if (nums.length == 0) return false;
        // i != j && nums[i] == nums[j] && abs(j - i) <= k
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j != i; j = (++j) % nums.length) {
                if (nums[i] == nums[j] && Math.abs(j - i) <= k) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) return false;
        // i != j && nums[i] == nums[j] && abs(j - i) <= k
        Map<Integer, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])) {
                hash.put(nums[i], new ArrayList<>());
            }
            List<Integer> integers = hash.get(nums[i]);
            if (integers.size() > 0) {
                for (int j = 0; j < integers.size(); j++) {
                    if (Math.abs(integers.get(j) - i) <= k) return true;
                }
            }
            integers.add(i);
        }
        return false;
    }
}

public class LeetCode_219_ContainsDuplicateII {

    public static void main(String[] args) {
        LeetCode_219_Solution solution = new LeetCode_219_Solution();
        System.out.println(solution.containsNearbyDuplicateNewMap(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicateNewMap(new int[]{1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicateNewMap(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(solution.containsNearbyDuplicateNewMap(new int[]{1}, 2));
        System.out.println(solution.containsNearbyDuplicateNewMap(new int[]{99, 99}, 2));
        System.out.println(solution.containsNearbyDuplicateNewMap(new int[]{1, 2, 1}, 1));
        System.out.println(solution.containsNearbyDuplicateNewMap(new int[]{1}, 1));
    }

}
