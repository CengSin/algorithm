package lintcode.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LintCode_56_Solution {
    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[]{};
        int[] pair = new int[2];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], new ArrayList<>());
            }
            map.get(numbers[i]).add(i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (map.containsKey(target - number)) {
                int index = 0;
                for (Integer integer: map.get(target - number)) {
                    if (integer != i) {
                        index = integer;
                        break;
                    }
                }
                pair[0] = Math.min(index, i);
                pair[1] = Math.max(index, i);
            }
        }

        return pair;
    }
}

// 两数字之和
public class LintCode_56_TwoSum {


}
