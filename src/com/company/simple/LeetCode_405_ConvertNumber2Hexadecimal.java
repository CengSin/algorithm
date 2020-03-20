package com.company.simple;

import java.util.Arrays;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/20
 */
class LeetCode_405_Solution {

    private final static String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public String toHexNew(int num) {
        if (num >= 0 && num < 16) return hex[num];
        int tmp = 0xf;

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int low = num & tmp;
            num = num >>> 4;
            sb.insert(0, hex[low]);
        }
        return sb.toString();
    }


        public String toHex(int num) {

        if (num >= 0 && num < 16) return hex[num];

        int[] binary = toBinary(num);

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < binary.length; i += 4) {
            int sum = 0;
            for (int j = i; j <= i + 3; j++) {
                sum = (sum << 1) | binary[j];
            }
            if (s.length() != 0 || !"0".equals(hex[sum])) {
                s.append(hex[sum]);
            }
        }

        return s.toString();
    }

    public int[] toBinary(int num) {
        int[] binary = new int[32];
        boolean isNega = false;
        int tmp = num;
        if (num < 0) {
            // 取反 + 1
            tmp = Math.abs(num);
            isNega = true;
        }
        int k = 31;
        while (tmp != 0) {
            binary[k--] = tmp % 2;
            tmp /= 2;
        }

        if (isNega) {
            for (int i = 1; i < 32; i++) {
                binary[i] = (binary[i] + 1) % 2;
            }
            binary[0] = 1;
            binary[31] += 1;
            for (int i = 31; i > 0; i--) {
                if (binary[i] > 1) {
                    binary[i - 1] += binary[i] >> 1;
                    binary[i] = binary[i] % 2;
                }
            }
        }
        return binary;
    }

}

public class LeetCode_405_ConvertNumber2Hexadecimal {
    public static void main(String[] args) {
        LeetCode_405_Solution solution = new LeetCode_405_Solution();
        System.out.println(solution.toHexNew(26));
        System.out.println(solution.toHexNew(-1));
        System.out.println(solution.toHexNew(16));
        System.out.println(solution.toHex(-2147483648));
    }

}
