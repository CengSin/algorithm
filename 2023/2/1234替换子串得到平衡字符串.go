package main

func balancedString(s string) int {
	n := len(s)
	partial := n / 4
	cntMap := make(map[byte]int)
	for _, c := range s {
		cntMap[byte(c)]++
	}

	check := func() bool {
		if cntMap['Q'] > partial ||
			cntMap['W'] > partial ||
			cntMap['E'] > partial ||
			cntMap['R'] > partial {
			return false
		}
		return true
	}

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	if check() {
		return 0
	}

	r, res := 0, len(s)
	for l, c := range s {
		for r < len(s) && !check() {
			cntMap[s[r]]--
			r++
		}

		// 如果找到了使得条件被满足的r，我们用r−l 来更新答案，然后令s[l] 的出现次数加1，
		//  并使得l 向右移动一个单位进行下一次枚举。否则，后序的l 也将不会有合法的r，此时我们可以直接跳出循环。
		if !check() {
			break
		}

		res = min(res, r-l)
		cntMap[byte(c)]++
	}

	return res
}
