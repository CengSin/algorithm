package main

// bs 在nums中查找target，并返回target的最小索引
func bs(nums []int, target int) int {
	i, j := 0, len(nums)

	for i < j {
		h := int(uint(i+j) >> 1)
		if nums[h] < target {
			i = h + 1
		} else {
			j = h
		}
	}
	return i
}

func searchCustom(nums []int, target int) int {
	left := bs(nums, target)
	if left == len(nums) {
		return 0
	}
	right := bs(nums, target+1) - 1
	return right - left + 1
}
