//如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
//
//
// 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
//
//
//
//
// 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
//
// 子数组 是数组中的一个连续序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4]
//输出：3
//解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -1000 <= nums[i] <= 1000
//
//
//
// Related Topics 数组 动态规划
// 👍 321 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func numberOfArithmeticSlices(nums []int) (ans int) {
	if len(nums) < 3 {
		return
	}

	dis, start := nums[1]-nums[0], 0
	for i := 1; i < len(nums)-1; i++ {
		if dis == nums[i+1]-nums[i] {
			start++
		} else {
			dis, start = nums[i+1]-nums[i], 0
		}
		ans += start
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
