package main

func longestWPI(hours []int) int {
	visit := make(map[int]int)
	s, res := 0, 0

	max := func(a, b int) int {
		if a > b {
			return a
		}

		return b
	}

	for i, hour := range hours {
		if hour > 8 {
			s += 1
		} else {
			s -= 1
		}

		if s > 0 {
			res = max(res, i+1)
		} else {
			j, exist := visit[s-1]
			if exist {
				res = max(res, i-j)
			}
		}

		_, exist := visit[s]
		if !exist {
			visit[s] = i
		}
	}

	return res
}
