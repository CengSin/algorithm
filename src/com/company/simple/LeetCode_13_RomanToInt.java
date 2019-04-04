package com.company.simple;


import java.util.Arrays;

/**
 * 罗马数字转数字
 */
public class LeetCode_13_RomanToInt {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MMMCMXCIX"));
        System.out.println(solution.romanToInt("I"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("DCLXVI"));
    }
}

class Solution {

    private final Integer THOUSANDS = 1000;
    private final Integer HUNDRED = 100;
    private final Integer TEN = 10;
    private final String orderOfRoman = "MDCLXVI";
    private final int[] weightOfRoman = {1000, 500, 100, 50, 10, 5, 1};

    /**
     * 罗马数字转数字
     *
     * 首先设置每一个罗马字符所对应的数字，之后通过传入的参数下标在权重数组中查询对应字母的数字，
     * 之后倒叙判断第一个字母是不是小于之前的字母，如果是，则符号位不变，如果不是，则变为负数，
     * 之后将数组中所有数字相加则为结果
     *
     * @param s 罗马数字字符串
     * @return int型数字
     */
    int romanToInt(String s) {
        int result;
        int[] weight = new int[s.length()];
        for (int i =0 ; i < s.length(); i++) {
            weight[i] = weightOfRoman[orderOfRoman.indexOf(s.charAt(i))];
        }
        int end =weight.length;
        for (end--; end >=1; --end) {
            if (weight[end] > weight[end - 1]) {
                weight[end-1] = 0-weight[end-1];
            }
        }
        result = Arrays.stream(weight).sum();
        return result;
    }

    /**
     * 数字转罗马数字
     * 将千位，百位，十位，个位的数字拿出来之后转为罗马字符串即可
     * @param s 数字
     * @return 罗马数字
     */
    String intToRoman(String s) {
        int num = Integer.parseInt(s);
        StringBuilder result = new StringBuilder();
        getThousands(num, result);
        num %= THOUSANDS;
        getHundred(num, result);
        num %= HUNDRED;
        getTen(num, result);
        num %= TEN;
        getDigits(num, result);
        return result.toString();
    }

    /**
     * 获取千位数
     * @param num 原数字
     * @param result StringBudiler
     * @return result
     */
    private StringBuilder getThousands(int num, StringBuilder result) {
        int thousands = num / THOUSANDS;
        for (thousands--; thousands >=0; --thousands) {
            result.append("M");
        }
        return result;
    }

    /**
     * 获取百位数
     * @param num 只有百位的原数字
     * @param result 结果
     * @return 结果
     */
    private StringBuilder getHundred(int num, StringBuilder result) {
        int hundred = num / HUNDRED;
        switch (hundred){
            case 9:
                result.append("CM");
                break;
            case 4:
                result.append("CD");
                break;
            default:
            {
                if (hundred >= 5) {
                    result.append("D");
                    hundred -= 5;
                }
                for (hundred--; hundred >= 0; --hundred) {
                    result.append("C");
                }
            }
            break;
        }
        return result;
    }

    /**
     * 获取十位数
     * @param num
     * @param result
     * @return
     */
    private StringBuilder getTen(int num, StringBuilder result) {
        int ten = num / TEN;
        switch (ten) {
            case 9:
                result.append("XC");
                break;
            case 4:
                result.append("XL");
                break;
            default:
            {
                if (ten >= 5) {
                    result.append("L");
                    ten -= 5;
                }
                for (ten--; ten>= 0; --ten) {
                    result.append("X");
                }
            }
                break;
        }
        return result;
    }

    /**
     * 获取个位数
     * @param num
     * @param result
     * @return
     */
    private StringBuilder getDigits(int num, StringBuilder result) {
        switch (num) {
            case 9:
                result.append("IX");
                break;
            case 4:
                result.append("IV");
                break;
            default:
            {
                if (num >= 5) {
                    result.append("V");
                    num -= 5;
                }
                for (num--; num>= 0; --num) {
                    result.append("I");
                }
            }
            break;
        }
        return result;
    }

}

