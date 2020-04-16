package com.company.simple;

import java.util.ArrayList;
import java.util.List;

class LeetCode_15_Solution {

    /**
     * 视频解释以及C++题解 https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-cshi-xian-shuang-zhi-zhen-fa-tu-shi/
     *
     * 思路：从数组下标0取一个数为num[i],在[i+1, nums.length()-1]的范围内搜索和等于-num[i]的两个数，
     * 如果(low + hight) > -nums[i] high --
     * 如果(low + hight) < -nums[i] low ++
     * 如果(low + hight) == -nums[i] 加入result
     * 之后循环找到不等于low的值和不等于hight的值继续遍历
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        insertSort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            if (num > 0) break;
            int low = i + 1;
            int hight = nums.length - 1;
            while (low < hight) {
                int lo = nums[low];
                int hi = nums[hight];
                if (lo + hi == -num) {
                    ArrayList<Integer> ints = new ArrayList<>();
                    ints.add(nums[low]);
                    ints.add(nums[hight]);
                    ints.add(nums[i]);
                    res.add(ints);
                    while (low < hight && lo == nums[low]) low++;  // 去重
                    while (low < hight && hi == nums[hight]) hight--; // 去重
                } else if (lo + hi > -num) {
                    hight--;
                } else {
                    low++;
                }
            }
            // 去重
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    nums[j] += nums[i];
                    nums[i] = nums[j] - nums[i];
                    nums[j] -= nums[i];
                }
            }
        }
    }

}

public class LeetCode_15_3Sum {

    public static void main(String[] args) {
        LeetCode_15_Solution solution = new LeetCode_15_Solution();
         List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        List<List<Integer>> lists = solution.threeSum(new int[]{0, 0, 0});
//        List<List<Integer>> lists = solution.threeSum(new int[]{0, 0, 0, 0});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
