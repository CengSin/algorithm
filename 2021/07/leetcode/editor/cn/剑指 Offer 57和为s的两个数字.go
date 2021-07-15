//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//
//
//
// 示例 1：
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
//
//
// 示例 2：
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
//
//
//
//
// 限制：
//
//
// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^6
//
// Related Topics 数组 双指针 二分查找
// 👍 119 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func twoSum(nums []int, target int) []int {
	for i := range nums {
		r := binarySearch(nums[i+1:], target-nums[i])
		if r != -1 {
			return []int{nums[i], r}
		}
	}
	return []int{}
}

func binarySearch(nums []int, t int) int {
	i, j := 0, len(nums)-1
	for i < j-1 {
		mid := i + (j-i)/2
		if nums[mid] == t {
			return nums[mid]
		} else if nums[mid] > t {
			j = mid
		} else {
			i = mid
		}
	}

	if nums[i] == t {
		return nums[i]
	}

	if nums[j] == t {
		return nums[j]
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)
