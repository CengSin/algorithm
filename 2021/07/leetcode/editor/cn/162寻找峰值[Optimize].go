package main

func findPeakElementOptimize(nums []int) int {
	i, j := 0, len(nums)-1
	for i < j {
		mid := (i + j) / 2
		if nums[mid] > nums[mid+1] {
			j = mid
		} else {
			i = mid + 1
		}
	}
	return i
}
