package com.company.simple;

class LeetCode_169_Solution {
    public int majorityElement(int[] nums) {
        int mostNum = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mostNum) count ++;
            else {
                count--;
                if (count == 0) mostNum = nums[i];
            }
        }

        return mostNum;
    }
}

public class LeetCode_169_MajorityElement {

    public static void main(String[] args) {
        LeetCode_169_Solution solution = new LeetCode_169_Solution();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}
