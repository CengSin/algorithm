//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。
//
//
// 示例 1：
//
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
//
//
// 示例 3：
//
//
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
//
//
//
//
// 进阶：
//
//
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
//
// Related Topics 数组 二分查找 动态规划
// 👍 1729 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func lengthOfLIS(nums []int) (ans int) {
	// 要求最长递增子序列
	// 思路，定义，dp[i]为以第i个元素结尾的子序列的最大长度
	// 从小到大计算dp[i]的值，在计算dp[i]之前,dp[0~i-1]的元素我们已经计算完成，所以状态转移方程为
	// dp[i] = max(dp[i], dp[j] + 1) 0 <= j <= i

	n := len(nums)
	dp := make([]int, n)
	dp[0] = 1
	ans = 1
	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	for i := 1; i < n; i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		ans = max(ans, dp[i])
	}

	return
}

//leetcode submit region end(Prohibit modification and deletion)
