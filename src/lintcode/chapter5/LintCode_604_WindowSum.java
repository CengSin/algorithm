package lintcode.chapter5;

import java.util.*;

/**
 * 滑动窗口问题
 */
class LintCode_604_Solution {
    /**
     * @param nums: a list of integers.
     * @param k:    length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {

        if (k <= 0 || nums == null || nums.length < k) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            res[0] += nums[i];
        }

        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        return res;
    }

    private int[] func1(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() == k) {
                // 求和
                int sum = 0;
                for (Integer integer : queue) {
                    sum += integer;
                }
                res.add(sum);
                queue.poll();
            }
        }

        int[] ansArr = new int[res.size()];
        int t = 0;
        for (Integer re : res) {
            ansArr[t++] = re;
        }
        return ansArr;
    }
}

public class LintCode_604_WindowSum {

    public static void main(String[] args) {
        LintCode_604_Solution solution = new LintCode_604_Solution();
        int[] res = solution.winSum(new int[]{1, 2, 7, 7, 2}, 3);
        System.out.println(Arrays.toString(res));
    }

}
