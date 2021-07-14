package main

func singleNonDuplicateOptimize(nums []int) int {
	lo, hi := 0, len(nums)-1
	for lo < hi {
		mid := lo + (hi-lo)/2
		halvesAreEven := ((hi - mid) % 2) == 0
		if nums[mid+1] == nums[mid] {
			if halvesAreEven {
				lo = mid + 2
			} else {
				hi = mid - 1
			}
		} else if nums[mid-1] == nums[mid] {
			if halvesAreEven {
				hi = mid - 2
			} else {
				lo = mid + 1
			}
		} else {
			return nums[mid]
		}
	}
	return nums[lo]
}
