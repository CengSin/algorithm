//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
//
//
//
// 示例 1：
//
//
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由小写英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 572 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)

// 由回文字符串的特性可得，将首尾两个字符删除之后，得到的字符串仍然是一个回文字符串。
// 设定一个二维数组dp，dp[i][j]表示字符串从i到j得到的最长回文子序列的长度。0 <= i <= j < n。字符本身长度为1，就是一个回文字符串，所以dp[i][j] = 1
// 字符串s如果大于1，那么下标i和下标j有两种情况
//    如果s[i] == s[j] ，那么dp[i][j]「从i到j的组最长回文子序列的长度」 = dp[i + 1][j - 1] + 2
//    如果s[i] != s[j] ，那么dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]) ，为什么是(i+1,j)和(i,j-1)，因为「i到j的子序列范围是[i+1, j-1]」
// 因为回文串是从短到长的，所以要从n-1开始循环i，j要大于i
// 最后dp[0][n-1]则为字符串中最长回文子序列的长度（n为s字符串的长度）
func longestPalindromeSubseq(s string) int {
	n := len(s)
	dp := make([][]int, n)
	for i := range dp {
		dp[i] = make([]int, n)
		dp[i][i] = 1
	}

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}

	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			if s[i] == s[j] {
				dp[i][j] = dp[i+1][j-1] + 2
			} else {
				dp[i][j] = max(dp[i+1][j], dp[i][j-1])
			}
		}
	}

	return dp[0][n-1]
}

//leetcode submit region end(Prohibit modification and deletion)
