package com.company.simple;

class Solution_69 {
    /**
     * 牛顿迭代法 位运算
     * @param x 要开方的数字
     * @return
     */
    public int mySqrt(int x) {
        if (x < 0) throw new RuntimeException("input number is not allow");
        else if (x < 2) return x;
        else {
            System.out.println("x >> 2 = " + (x >> 2));
            int small = mySqrt(x>>2) << 1;
            System.out.println("small = " + small);
            int large = small + 1;
            // 此处强制转为double是为了防止溢出
            double tmp = ((double)small * small) + (small + large);
            if (tmp > x) {
                return small;
            } else {
              return large;
            }
        }
    }
}

public class LeetCode_69_Sqrt_x {

    public static void main(String[] args) {
        Solution_69 s = new Solution_69();
//        System.out.println(s.mySqrt(4));
//        System.out.println(s.mySqrt(8));
//        System.out.println(s.mySqrt(12));
        System.out.println(s.mySqrt(100));
//        System.out.println(s.mySqrt(2147395600));
    }

}
