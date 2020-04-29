package com.company.simple;

class MountainArray {

    int[] arr = new int[]{0, 5, 3, 1};

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}

class Solution {

    private final int NOT_FOUND = -1;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr == null || mountainArr.length() == 0) return -1;
        int start = 0, end = mountainArr.length() - 1;
        // 先找山顶元素
        int topIndex = findMountainTop(mountainArr, start, end);
        // 在前半段升序数组中查找元素值
        int res = binarySearchASC(mountainArr, 0, topIndex, target);
        if (res == NOT_FOUND) {
            // 在后半段降序数组中查找元素值
            res = binarySearchDesc(mountainArr, topIndex, end, target);
        }
        return res;
    }

    private int binarySearchDesc(MountainArray mountainArr, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (mountainArr.get(start) == target) return start;
        if (mountainArr.get(end) == target) return end;
        return NOT_FOUND;
    }

    private int binarySearchASC(MountainArray mountainArr, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (mountainArr.get(start) == target) return start;
        if (mountainArr.get(end) == target) return end;
        return NOT_FOUND;
    }

    private int findMountainTop(MountainArray mountainArr, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (mountainArr.get(start) > mountainArr.get(end)) {
            return start;
        }
        return end;
    }
}

public class LeetCode_1095_FindInMountainArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int inMountainArray = solution.findInMountainArray(1, new MountainArray());
        System.out.println(inMountainArray);
    }

}
