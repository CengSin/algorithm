//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 329 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
package main

import "sort"

func permutation(s string) (ans []string) {
	t := []byte(s)
	sort.Slice(t, func(i, j int) bool { return t[i] < t[j] })
	n := len(t)
	perm := make([]byte, 0, n)
	vis := make([]bool, n)
	var backtrack func(int)
	backtrack = func(i int) {
		if i == n {
			ans = append(ans, string(perm))
			return
		}
		for j, b := range vis {
			if b || j > 0 && !vis[j-1] && t[j-1] == t[j] {
				continue
			}
			vis[j] = true
			perm = append(perm, t[j])
			backtrack(i + 1)
			perm = perm[:len(perm)-1]
			vis[j] = false
		}
	}
	backtrack(0)
	return
}

//leetcode submit region end(Prohibit modification and deletion)
