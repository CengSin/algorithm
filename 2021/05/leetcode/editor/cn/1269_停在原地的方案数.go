package main

//有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
//
// 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
//
// 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
//
// 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
//
//
//
// 示例 1：
//
// 输入：steps = 3, arrLen = 2
//输出：4
//解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
//向右，向左，不动
//不动，向右，向左
//向右，不动，向左
//不动，不动，不动
//
//
// 示例 2：
//
// 输入：steps = 2, arrLen = 4
//输出：2
//解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
//向右，向左
//不动，不动
//
//
// 示例 3：
//
// 输入：steps = 4, arrLen = 2
//输出：8
//
//
//
//
// 提示：
//
//
// 1 <= steps <= 500
// 1 <= arrLen <= 10^6
//
// Related Topics 动态规划
// 👍 64 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
func numWays(steps int, arrLen int) int {
	const mod = 1e9 + 7
	// dp[i][j]表示第i步之后在下标j的方案树, 0 <= i <= steps, 0 <= j <= steps
	//  dp[i][j] = dp[i - 1][j] + dp[i-1][j-1] + dp[i - 1][j+1]
	// 移动的最大数量为 min(arrLen - 1, steps)
	// dp[0][0] = 1 当没有任何操作时，指针0一定位于下标0之上，所以方案只有1中
	// dp[0][j] = 0 不进行任何操作，指针0到第j个下标都是0，所以方案 = 0

	dpMaxCol := min(steps, arrLen-1)
	dp := make([][]int, steps+1)
	for i := 0; i < steps+1; i++ {
		dp[i] = make([]int, dpMaxCol+1)
	}

	dp[0][0] = 1

	for i := 1; i < steps+1; i++ {
		for j := 0; j <= dpMaxCol; j++ {
			dp[i][j] = dp[i-1][j]
			if j-1 >= 0 {
				dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % mod
			}

			if j+1 <= dpMaxCol {
				dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % mod
			}
		}
	}

	return dp[steps][0]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

//leetcode submit region end(Prohibit modification and deletion)
