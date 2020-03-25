package com.company.simple;

/**
 * @description: 解码字母到整数映射
 * @author: 15262
 * @date: 2020/3/25
 */

class LeetCode_1309_Solution {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i){
            int ch = s.charAt(i);
            if (ch == '#') {
                int number = s.charAt(--i) - '0';
                int ten = s.charAt(--i) - '0';
                sb.insert(0, (char) ('a' + (ten * 10 + number - 1)));
            } else {
                sb.insert(0, (char) ('a' + (ch - '0' - 1)));
            }
        }
        return sb.toString();
    }

}

public class LeetCode_1309_DecryptStringFromAlphabet2IntegerMapping {

    public static void main(String[] args) {
        LeetCode_1309_Solution solution = new LeetCode_1309_Solution();
        System.out.println(solution.freqAlphabets("1326#"));  // acz
        System.out.println(solution.freqAlphabets("10#11#12"));
        System.out.println(solution.freqAlphabets("25#"));
        System.out.println(solution.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

}
