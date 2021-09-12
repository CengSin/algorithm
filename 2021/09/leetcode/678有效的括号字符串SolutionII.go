package main

func checkValidString(s string) bool {
	sign := [3]int{0}
	for _, c := range s {
		if c == ')' {
			sign[0]--
		} else {
			sign[0]++
			if c == '*' {
				sign[1]++
			}
		}

		if sign[0] < 0 {
			return false
		}
	}

	for i := len(s) - 1; i >= 0; i-- {
		if c := s[i]; c == '(' {
			sign[2]--
		} else {
			sign[2]++
			if c == '*' {
				sign[1]++
			}
		}

		if sign[2] < 0 {
			return false
		}
	}

	return sign[0]+sign[2] == sign[1]*2
}
