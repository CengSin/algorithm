package leetcode

const L = 10

func findRepeatedDnaSequences(s string) (ans []string) {
	repMap := map[string]int{}
	for i := 0; i <= len(s)-L; i++ {
		s2 := s[i : i+L]
		repMap[s2]++
		if repMap[s2] == 2 {
			ans = append(ans, s2)
		}
	}

	return
}
