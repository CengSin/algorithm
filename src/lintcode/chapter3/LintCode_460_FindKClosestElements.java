package lintcode.chapter3;

import java.util.Arrays;

/**
 * 给一个目标数 target, 一个非负整数 k, 一个按照升序排列的数组 A。
 * 在A中找与target最接近的k个整数。返回这k个数并按照与target的接近程度从小到大排序，
 * 如果接近程度相当，那么小的数排在前面。
 */
class LintCode_460_Solution {
    /**
     * @param A:      an integer array
     * @param target: An integer
     * @param k:      An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else if (A[mid] <= target) {
                start = mid;
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int valS = start >= 0 ? -(A[start] - target) : Integer.MAX_VALUE;
            int valE = end < A.length ? A[end] - target : Integer.MAX_VALUE;
            if (valS <= valE) res[i] = A[start--];
            else res[i] = A[end++];
        }

        return res;
    }
}

public class LintCode_460_FindKClosestElements {

    public static void main(String[] args) {
        LintCode_460_Solution solution = new LintCode_460_Solution();
        System.out.println(Arrays.toString(solution.kClosestNumbers(new int[]{1, 2, 3}, 2, 3)));
    }

}
