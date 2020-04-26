package lintcode.chapter3;

class LintCode_75_Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else { // A[mid] >= A[mid - 1] && A[mid] >= A[mid + 1]
                return mid;
            }
        }
        return Math.max(A[start], A[end]);
    }
}

public class LintCode_75_FindPeakElement {
}
