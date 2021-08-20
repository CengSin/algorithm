//给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例 1：
//
//
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
//
//
// 示例 2：
//
//
//输入：s = "abcd", k = 2
//输出："bacd"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由小写英文组成
// 1 <= k <= 10⁴
//
// Related Topics 双指针 字符串 👍 181 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func reverseStr(s string, k int) string {
	if len(s) == 0 {
		return ""
	}

	if len(s) < k {
		return reverse(s)
	}

	return reverse(s[:k]) + s[k:min(len(s), 2*k)] + reverseStr(s[min(len(s), 2*k):], k)
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func reverse(s string) string {
	t := []rune(s)
	i, j := 0, len(t)-1
	for i < j {
		t[i], t[j] = t[j], t[i]
		i++
		j--
	}

	return string(t)
}

//leetcode submit region end(Prohibit modification and deletion)
