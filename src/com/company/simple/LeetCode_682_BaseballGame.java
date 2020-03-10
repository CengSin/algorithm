package com.company.simple;

/**
 * @description: 棒球比赛
 * @author: 15262
 * @date: 2020/3/10
 */
class LeetCode_682_Solution {

    public int calPoints(String[] ops) {
        if (ops == null) return 0;
        int sum = 0;
        int length = ops.length;
        for (int i = 0; i < length; i++) {
            switch (ops[i]) {
                case "C":
                    sum -= Integer.parseInt(ops[i - 1]);
                    for (int j = i - 1; j < length - 2; j++) {
                        ops[j] = ops[j + 2];
                    }
                    i = Math.max(i - 2, -1);
                    length = Math.max(length - 2, 0);
                    break;
                case "D": {
                    int num = Integer.parseInt(ops[i - 1]) * 2;
                    sum += num;
                    ops[i] = num + "";
                    break;
                }
                case "+":
                    int num = Integer.parseInt(ops[i - 1]) + Integer.parseInt(ops[i - 2]);
                    sum += num;
                    ops[i] = num + "";
                    break;
                default:
                    sum += Integer.parseInt(ops[i]);
                    break;
            }
        }

        return sum;
    }

}

public class LeetCode_682_BaseballGame {

    public static void main(String[] args) {
        LeetCode_682_Solution solution = new LeetCode_682_Solution();
         System.out.println(solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(solution.calPoints(new String[]{"1","C","-62","-45","-68"}));
    }

}
