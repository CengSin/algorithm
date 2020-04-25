package lintcode.chapter3;

class ArrayReader {
    private int[] nums;

    public ArrayReader(int[] nums) {
        this.nums = new int[Integer.MAX_VALUE];
    }

    public int get(int k) {
        return nums[k];
    }
}

/**
 * 给一个按照升序排序的非负整数数组。这个数组很大以至于你只能通过固定的接口 ArrayReader.get(k) 来访问第k个数(或者C++里是ArrayReader->get(k))，
 * 并且你也没有办法得知这个数组有多大。
 * <p>
 * 找到给出的整数target第一次出现的位置。你的算法需要在O(logk)的时间复杂度内完成，k为target第一次出现的位置的下标。
 * <p>
 * 如果找不到target，返回-1。
 * <p>
 * 倍增法确定数组范围，二分法查找元素位置
 */
class LintCode_447_Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int start = 0, end = getEndIndex(reader, target);

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = reader.get(mid);
            if (midVal >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (reader.get(start) == target) return start;
        if (reader.get(end) == target) return end;
        return -1;
    }

    private int getEndIndex(ArrayReader reader, int target) {
        int index = 0;
        while (reader.get(index) <= target) {
            index = (index << 1) + 1;
        }
        return index;
    }
}

public class LintCode_447_SearchInBigSortedArray {
}
