package main

func findIntegers(n int) (ans int) {
	k, dp := 32, [32]int{1, 2}
	for i := 2; i < k; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}

	k = 31
	pre := 0
	for k >= 0 {
		if n&(1<<k) != 0 {
			ans += dp[k]
			if pre == 1 {
				return ans
			}
			pre = 1
		} else {
			pre = 0
		}
		k -= 1
	}

	return ans + 1
}
