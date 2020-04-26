package lintcode.chapter3;

class LintCode_141_Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        int start = 1, end = x;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid * mid < x) {
                start = mid;
            } else if (mid * mid == x){
                return mid;
            } else {
                end = mid;
            }
        }

        if (end > x / end)  return start;
        return end;
    }
}

public class LintCode_141_Sqrtx {
}
