package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 整数转罗马数字
 */
class LeetCode_12_Solution {

    // 贪心算法
    public String intToRoman4ms(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 ,5, 4, 1};
        String[] romes = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;

        while(index < 13) {
            while(num >= nums[index]) {
                stringBuilder.append(romes[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    private final int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private final String[] strs = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        if (num < 1) return "";

        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            while (num < 4) {
                list.add(0);
                num--;
                break;
            }
            if (num >= 4) {
                // 二分查找第一个小于num的值
                int i = binaryLessNum(num, 0, nums.length - 1);
                num -= nums[i];
                list.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(strs[list.get(i)]);
        }
        return sb.toString();
    }

    private int binaryLessNum(int num, int left, int right) {
        if (left >= right) return left;
        int mid = left + (right - left) / 2;
        if (nums[mid] < num) {
            if (mid + 1 < nums.length && nums[mid + 1] > num) {
                return mid;
            }
            return binaryLessNum(num, mid + 1, right);
        }
        else if (nums[mid] > num) return binaryLessNum(num, left, mid - 1);
        else return mid;
    }

}

public class LeetCode_12_Integer2Roman {

    public static void main(String[] args) {
        LeetCode_12_Solution solution = new LeetCode_12_Solution();
        System.out.println(solution.intToRoman(0));
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(3000));
    }

}
