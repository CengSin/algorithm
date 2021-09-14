package main

import "sort"

func findLongestWord(s string, dictionary []string) string {
	sort.Slice(dictionary, func(i, j int) bool {
		if len(dictionary[i]) > len(dictionary[j]) {
			return true
		} else if len(dictionary[i]) == len(dictionary[j]) {
			return dictionary[i] < dictionary[j]
		}
		return false
	})

	// 题目中要求找到dictionary中的符合条件「s字符串通过删除一些字符可以变成的最长的，字典序最小的」的字符串
	// 采用贪心的算法，因为如果字符串c出现在x1，x2两个位置，一定要首先选择x1的位置，因为选择了x1的位置，x1的后续字符可以匹配到s中。
	for _, t := range dictionary {
		// 通过双指针判断t是否为s的子序列
		// 如果t[i] == s[j]，那么i++，j++
		// 如果t[i] != s[j]，那么j++
		// 只移动s的指针，判断t是否能被遍历完，如果能，就说明t是s的子序列，否则，t不是s的子序列
		i := 0
		for j := 0; j < len(s); j++ {
			if t[i] == s[j] {
				i++
			}
			if i == len(t) {
				return t
			}
		}
	}

	return ""
}
