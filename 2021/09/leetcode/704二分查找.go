package main

func search(nums []int, target int) int {
	s, e := 0, len(nums)-1
	for s < e-1 {
		mid := (s + e) >> 1
		if nums[mid] == target {
			return mid
		}
		if nums[mid] > target {
			e = mid - 1
		}
		if nums[mid] < target {
			s = mid + 1
		}
	}

	if nums[s] == target {
		return s
	}

	if nums[e] == target {
		return e
	}

	return -1
}
