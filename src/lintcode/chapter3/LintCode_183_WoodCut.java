package lintcode.chapter3;

import java.util.Arrays;

class LintCode_183_Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) return -1;

        int start = 1, end = Arrays.stream(L).max().getAsInt();

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getPerices(mid, L) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getPerices(end, L) >= k) return end;
        if (getPerices(start, L) >= k) return start;
        return -1;
    }

    private int getPerices(int mid, int[] l) {
        int sum = 0;
        for (int i : l) {
            sum += (i / mid);
        }
        return sum;
    }
}

public class LintCode_183_WoodCut {
}
