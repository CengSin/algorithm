package com.company.may;

class LeetCode_152_Solution {
    public int maxProduct(int[] nums) {
        // 最大值 之前的最大值，最小值，为了防止负数出现的情况
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}

public class LeetCode_152_MaximumProductSubarray {
}
