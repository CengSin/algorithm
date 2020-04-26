package lintcode.chapter3;

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */

class LintCode_74_SVNRepo {
    static boolean isBadVersion(int k) {
        return false;
    }
}

class LintCode_74_Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (LintCode_74_SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (LintCode_74_SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}

public class LintCode_74_FirstBadVersion {
}
