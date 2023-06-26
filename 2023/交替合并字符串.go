package main

// 递归解法，阅读性差，内存使用高，且执行效率低
//func mergeAlternately(word1 string, word2 string) string {
//	if len(word1) == 0 || len(word2) == 0 {
//		return word1 + word2
//	}
//
//	if len(word1) == 1 {
//		return word1 + word2
//	}
//
//	if len(word2) == 1 {
//		return string(word1[0]) + string(word2[0]) + word1[1:]
//	}
//
//	return string(word1[0]) + string(word2[0]) + mergeAlternately(word1[1:], word2[1:])
//}

func mergeAlternately(word1 string, word2 string) string {
	n := len(word1)
	m := len(word2)
	ans := make([]byte, 0, n+m)
	for i := 0; i < n || i < m; i++ {
		if i < n {
			ans = append(ans, word1[i])
		}
		if i < m {
			ans = append(ans, word2[m])
		}
	}
	return string(ans)
}

func main() {

}
