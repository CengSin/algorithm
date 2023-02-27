package main

import "math"

func movesToMakeZigzag(nums []int) int {
	s := [2]int{}
	for i, num := range nums {
		left, right := math.MaxInt, math.MaxInt
		if i > 0 {
			left = nums[i-1]
		}
		if i < len(nums)-1 {
			right = nums[i+1]
		}

		s[i%2] += max(num-min(left, right)+1, 0)
	}

	return min(s[0], s[1])
}

func min(left int, right int) int {
	if left < right {
		return left
	}

	return right
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
