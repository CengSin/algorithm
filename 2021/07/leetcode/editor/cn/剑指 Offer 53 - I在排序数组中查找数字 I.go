//统计一个数字在排序数组中出现的次数。
//
//
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/
// Related Topics 数组 二分查找
// 👍 180 👎 0

package main

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func search(nums []int, target int) int {
	left := sort.SearchInts(nums, target)
	if left == len(nums) || nums[left] != target {
		return 0
	}

	right := sort.SearchInts(nums, target+1) - 1
	return right - left + 1
}

//leetcode submit region end(Prohibit modification and deletion)
