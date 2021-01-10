package main

import "fmt"

func summaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return nil
	}

	var result []string
	for i := 0; i < len(nums); i++ {
		k := i
		for k < len(nums)-1 && nums[k+1]-nums[k] == 1 {
			k++
		}
		if i != k {
			result = append(result, fmt.Sprintf("[%d->%d]", nums[i], nums[k]))
		} else {
			result = append(result, fmt.Sprintf("[%d]", nums[k]))
		}
		if k == len(nums) {
			break
		}
		i = k
	}

	return result
}

func main() {
	nums := []int{-1}
	summaryRanges(nums)
}
