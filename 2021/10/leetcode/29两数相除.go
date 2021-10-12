package leetcode

import "math"

func divide(dividend int, divisor int) int {
	if dividend == math.MinInt32 && divisor == -1 {
		return math.MaxInt32
	}

	if divisor == 1 {
		return dividend
	}

	flag := (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)

	if dividend > 0 {
		dividend = -dividend
	}

	if divisor > 0 {
		divisor = -divisor
	}

	ans := 0
	for {
		a, b, cnt := dividend, divisor, 1
		if a > b {
			break
		}

		for a <= b+b {
			cnt += cnt
			b += b
		}

		ans += cnt
		dividend -= b
	}

	if flag {
		return ans
	}
	return -ans
}
