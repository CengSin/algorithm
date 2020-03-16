package com.company.simple;

/**
 * @description: 压缩字符串
 * @author: zhangzetao
 * @date: 2020/3/16
 */

class LeetCode_01_06_Solution {

    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int count = 1;
            while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(S.charAt(i)).append(count);
        }

        if (sb.length() >= S.length()) {
            return S;
        }
        return sb.toString();
    }

}

public class LeetCode_01_06_CompressStringLCCI {

    public static void main(String[] args) {
        LeetCode_01_06_Solution solution = new LeetCode_01_06_Solution();
        String compress = solution.compressString("aabcccccaaa");
        System.out.println(compress);
        compress = solution.compressString("abbccd");
        System.out.println(compress);
    }

}
