package main

//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
//
//
//
// 示例 1:
//
//
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
//
// 示例 2:
//
//
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// nums[i] 不是 0 就是 1
//
// Related Topics 哈希表
// 👍 354 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
func findMaxLength(nums []int) (maxLength int) {
	count := 0
	visitor := map[int]int{0: -1}

	for i, num := range nums {
		if num == 1 {
			count++
		} else {
			count--
		}

		if preIndex, has := visitor[count]; has {
			// 前缀和相通表示具有相同的0和1
			maxLength = max525(maxLength, i-preIndex)
		} else {
			visitor[count] = i
		}
	}

	return
}

func max525(a, b int) int {
	if a > b {
		return a
	}
	return b
}

//leetcode submit region end(Prohibit modification and deletion)
