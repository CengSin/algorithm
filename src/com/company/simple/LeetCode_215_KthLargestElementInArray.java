package com.company.simple;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给一个未排序的数组，返回数组中第k个最大元素
 */
class LeetCode_215_Solution {

    public int findKthLargestByHeap(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int tmp = nums[i];
            while (j >= 0 && nums[j] >= tmp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

}

public class LeetCode_215_KthLargestElementInArray {

    public static void main(String[] args) {
        LeetCode_215_Solution solution = new LeetCode_215_Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 3));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

}
