package main

import "fmt"

func search(nums []int, target int) bool {
	// 二分查找
	n := len(nums)
	if n == 0 {
		return false
	}
	if n == 1 {
		return nums[0] == target
	}
	l, r := 0, n-1
	for l <= r {
		mid := (l + r) / 2
		if nums[mid] == target {
			return true
		}
		if nums[l] == nums[mid] && nums[mid] == nums[r] {
			l++
			r--
		} else if nums[l] <= nums[mid] {
			if nums[l] <= target && target < nums[mid] {
				r = mid - 1
			} else {
				l = mid + 1
			}
		} else {
			if nums[mid] < target && target <= nums[n-1] {
				l = mid + 1
			} else {
				r = mid - 1
			}
		}
	}
	return false
}

func loopFind(nums []int, target int) bool {
	for _, num := range nums {
		if target == num {
			return true
		}
	}
	return false
}

func main() {
	//b := search([]int{2, 5, 6, 0, 0, 1, 2}, 0)
	b := search([]int{1, 0, 1, 1, 1}, 0)
	fmt.Println(b)
}
