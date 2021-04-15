package main

func rob(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	}

	if n == 2 {
		return max(nums[0], nums[1])
	}

	return max(_rob(nums[:n-1]), _rob(nums[1:]))
}

func _rob(nums []int) int {
	pre, cur := 0, 0
	for _, num := range nums {
		pre, cur = cur, max(pre+num, cur)
	}
	return cur
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
