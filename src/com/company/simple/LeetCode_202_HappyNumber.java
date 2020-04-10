package com.company.simple;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LeetCode_202_Solution {

    private final static List<Integer> notHappyNumbers = Stream.of(4, 16, 37, 58, 89, 145, 42, 20).collect(Collectors.toList());
    private final static List<Integer> happyNumbers = Stream.of(1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100).collect(Collectors.toList());

    public boolean isHappy(int n) {

        if (happyNumbers.contains(n)) return true;
        else if (notHappyNumbers.contains(n)) return false;
        else {
            int sum = 0;
            while (n != 0) {
                int tmp = n % 10;
                sum += tmp * tmp;
                n /= 10;
            }
            if (isHappy(sum)) {
                // happyNumbers.add(n);
                return true;
            }
            // notHappyNumbers.add(n);
            return false;
        }

    }

}

public class LeetCode_202_HappyNumber {

    public static void main(String[] args) {
        LeetCode_202_Solution solution = new LeetCode_202_Solution();
        System.out.println(solution.isHappy(19));
    }

}
