package main

//求第N个丑数

// 三指针，求最小的数，最开始的数组是[2, 3, 5]
func nthUglyNumber(n int) int {

	if n <= 0 {
		return 0
	}

	var result = make([]int, n)

	for i, _ := range result {
		result[i] = 1
	}

	index2, index3, index5 := 0, 0, 0

	for i := 1; i < n; i++ {
		result[i] = minNumber(minNumber(2*result[index2], 3*result[index3]), 5*result[index5])
		if result[i] == 2*result[index2] {
			index2 += 1
		}
		if result[i] == 3*result[index3] {
			index3 += 1
		}
		if result[i] == 5*result[index5] {
			index5 += 1
		}
	}

	return result[n-1]
}

func minNumber(a, b int) int {
	if a < b {
		return a
	}
	return b
}
