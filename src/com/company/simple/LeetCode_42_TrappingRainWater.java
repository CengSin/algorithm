package com.company.simple;

/**
 * @description: 接雨水
 * @author: 15262
 * @date: 2020/4/4
 */

class LeetCode_42_Solution {

    public int trap(int[] height) {
//        int sum = Arrays.stream(height).sum();
//        int maxLen = Arrays.stream(height).max().orElse(0);
//        int area = 0;
//        while (maxLen-- > 0) {
//            每次-1计算每一行的面积，如果高度很高的话，就相当于O(n^n)，会超时
//            int minIndex = height.length;
//            int maxIndex = 0;
//            for (int i = 0; i < height.length; i++) {
//                if (height[i] > 0) {
//                    if (i < minIndex) minIndex = i;
//                    if (i > maxIndex) maxIndex = i;
//                    height[i]--;
//                }
//            }
//            area += (maxIndex - minIndex) + 1;
//        }
//        return area - sum;

// 思路二：定义一个数组作为栈，从height中第一个不为0的数字开始入栈，如果后来的数字要大于栈中最大的数字，则计算栈中的水容量sum（栈中的最大值 - 栈里面的每个元素）,之后清空栈，再次循环
        // 使用双指针，i表示栈中的容量，j表示要进入栈的下标
        // 找到第一个不为零的元素开始入栈
        if (height.length < 2) return 0;
        int firstNonZeroIndex = 0;
        for (; firstNonZeroIndex < height.length; firstNonZeroIndex++) {
            if (height[firstNonZeroIndex] != 0) {
                break;
            }
        }
        // 如果第一个不为0的元素就是数组结尾 或者 第一个不为零的元素长度下一个元素数组结尾 都接不到水
        if (firstNonZeroIndex == height.length - 1 || firstNonZeroIndex + 1 == height.length - 1)
            return 0;
        int j = firstNonZeroIndex + 1, poolStartPoint = height[firstNonZeroIndex], sum = 0;
        // 这种只能判断终点高于等于起点的情况
        while (firstNonZeroIndex < j && j < height.length) {
            // 如果某个值大于这个起点，说明可以盛水
            if (height[j] >= poolStartPoint) {
                // 计算栈中能够盛水的容量
                for (int i = firstNonZeroIndex + 1; i < j; i++) {
                    sum += (poolStartPoint - height[i]);
                }
                // 更换起点
                firstNonZeroIndex = j;
                poolStartPoint = height[firstNonZeroIndex];
            }
            j = j + 1;
        }
        // 起点高于等于终点 //
        // 交换 j， firstNonZero，此时j是终点，firstNonZero是逆序的起点
        firstNonZeroIndex = j + firstNonZeroIndex;
        j = firstNonZeroIndex - j;
        firstNonZeroIndex -= j;
        firstNonZeroIndex -= 1;
        poolStartPoint = height[firstNonZeroIndex];
        int next = firstNonZeroIndex - 1;
        while (next >= j) {
            if (height[next] >= poolStartPoint) {
                for (int i = firstNonZeroIndex; i > next ; i--) {
                    sum += poolStartPoint - height[i];
                }
                firstNonZeroIndex = next;
                poolStartPoint = height[firstNonZeroIndex];
            }
            next --;
        }
        return sum;
    }

}

public class LeetCode_42_TrappingRainWater {

    public static void main(String[] args) {
        LeetCode_42_Solution solution = new LeetCode_42_Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap(new int[]{2, 2}));
        System.out.println(solution.trap(new int[]{0}));
        System.out.println(solution.trap(new int[]{2, 0, 2}));
        System.out.println(solution.trap(new int[]{4, 2, 3, 0, 1}));
    }

}
