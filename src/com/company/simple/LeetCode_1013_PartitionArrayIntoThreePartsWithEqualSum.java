package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 将数组分成和相等的三个部分
 * @author: 15262
 * @date: 2020/3/11
 */
class LeetCode_1013_Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        // if arr_sum % 3 == 0 todo
        // else false
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 == 0) {
            int splitNum = sum / 3;
            int tmp = 0;
            List<Integer> indexs = new ArrayList<>();
            for (int i = 0; i < A.length; i++) {
                tmp += A[i];
                if (tmp == splitNum) {
                    indexs.add(i);
                    tmp = 0;
                }
            }
            return indexs.size() == 3 || (sum == 0 && indexs.size() >= 3);
        }
        return false;
    }
}

public class LeetCode_1013_PartitionArrayIntoThreePartsWithEqualSum {

    public static void main(String[] args) {
        LeetCode_1013_Solution solution = new LeetCode_1013_Solution();
        assert solution.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1});
        assert !solution.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1});
        assert solution.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4});
    }

}
