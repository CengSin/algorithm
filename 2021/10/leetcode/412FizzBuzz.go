package leetcode

import "strconv"

func fizzBuzz(n int) (ans []string) {
	for i := 1; i <= n; i++ {
		s := ""
		if i%3 == 0 {
			s += "Fizz"
		}
		if i%5 == 0 {
			s += "Buzz"
		}

		if len(s) == 0 {
			ans = append(ans, strconv.Itoa(i))
		} else {
			ans = append(ans, s)
		}
	}
	return
}
