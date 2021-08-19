//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
//
//
//
// 示例 1：
//
//
//输入：s = "hello"
//输出："holle"
//
//
// 示例 2：
//
//
//输入：s = "leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 10⁵
// s 由 可打印的 ASCII 字符组成
//
// Related Topics 双指针 字符串 👍 203 👎 0

package main

import "strings"

//leetcode submit region begin(Prohibit modification and deletion)
func reverseVowels(s string) string {
	t, n := []rune(s), len(s)
	i, j := 0, n-1

	for i < j {
		for i < n && !strings.ContainsRune("aeiouAEIOU", t[i]) {
			i++
		}

		for j >= 0 && !strings.ContainsRune("aeiouAEIOU", t[j]) {
			j--
		}

		if i < j {
			t[i], t[j] = t[j], t[i]
			i++
			j--
		}
	}

	return string(t)
}

//leetcode submit region end(Prohibit modification and deletion)
