package com.company.simple;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
 * "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
 */

class MyList<E> extends ArrayList<E> {
    @Override
    public String toString() {
        int len = this.size();
        if (len == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (len--; len >=0 ; --len) {
            sb.append(this.get(len) == this ? "(this Collection)" : this.get(len));
        }
        return sb.toString();
    }
}

class Solution_67 {

    String addBinary(String a, String b) {
        List<Integer> cList = new MyList<>();
        int aLen = a.length();
        int bLen = b.length();
        for (aLen--, bLen--; aLen>=0 && bLen >=0; --aLen, --bLen) {
            int num1 = a.charAt(aLen) - '0';
            int num2 = b.charAt(bLen) - '0';
            cList.add(num1 + num2);
        }
        getLastSubStr(a, cList, aLen);
        getLastSubStr(b, cList, bLen);
        int realLen = cList.size()-1;
        for (int i = 0; i < realLen; i++) {
            Integer iNumber = cList.get(i);
            Integer iNextNumber = cList.get(i + 1);
            if (iNumber >= 2) {
                cList.set(i, iNumber%2);
                cList.set(i+1, iNextNumber + 1);
            }
        }
        Integer lastNumber = cList.get(realLen);
        if (lastNumber >= 2) {
            cList.set(realLen, lastNumber%2);
            cList.add(1);
        }
        return String.valueOf(cList);
    }

    private void getLastSubStr(String s, List<Integer> list, int len) {
        while (len >= 0) {
            list.add(s.charAt(len) - '0');
            len--;
        }
    }
}

class Solution_more_quick_67 {

    public static String addBinary(String a, String b) {
        // 去两个字符串中最大的长路
        int len = a.length() < b.length()? b.length() : a.length();
        // 把两个字符串变成整型数组
        int[] aa = str2Arr(a, len);
        int[] bb = str2Arr(b, len);
        // 两个数组相加
        int x = 0;
        for (int i = 0; i < len; i ++) {
            aa[len - i - 1] = bb[len - i - 1] + aa[len - i - 1] + x;
            if (aa[len - i - 1] >= 2) {
                aa[len - i - 1]%=2;
                x = 1;
            } else {
                x = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (x == 1) {
            aa[0] %= 2;
            sb.append("1");
        }
        for (int i = 0; i < len; i++) {
            sb.append(aa[i]);
        }
        return sb.toString();
    }

    private static int[] str2Arr(String b, int len) {
        int[] bb = new int[len];
        for (int i = 0; i < b.length(); i++) {
            bb[len - i - 1] = b.charAt(b.length() - i - 1) - '0';
        }
        return bb;
    }

}

public class LeetCode_67_AddBinary {

    public static void main(String[] args) {
        Solution_67 s = new Solution_67();
        long startTime = System.currentTimeMillis();
        String result = s.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(result);

        Solution_more_quick_67 s1 = new Solution_more_quick_67();
        long startTime1 = System.currentTimeMillis();
        String result1 = s1.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
        System.out.println(System.currentTimeMillis() - startTime1);
        System.out.println(result);
    }

}
