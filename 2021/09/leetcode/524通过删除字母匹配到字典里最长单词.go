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
