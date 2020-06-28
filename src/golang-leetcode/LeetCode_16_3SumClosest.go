package main

import (
	"math"
	"sort"
)

// 首先排序，然后for循环遍历nums中的值，之后用左右双指针来查找与target最接近的值
func threeSumClosest(nums []int, target int) int {
	numsLen := len(nums)
	if numsLen < 3 {
		return 0
	}

	sort.Ints(nums)

	closestNum := nums[0] + nums[1] + nums[2]

	for i := 0; i < numsLen - 2; i++ {
		l, r := i + 1, numsLen - 1
		for l < r {
			threeSum := nums[i] + nums[l] + nums[r]
			thrSumSubTrg := math.Abs(float64(threeSum - target))
			clsNumSubTrg := math.Abs(float64(closestNum - target))
			if thrSumSubTrg < clsNumSubTrg {
				closestNum = threeSum
			}
			if threeSum > target {
				r--
			} else if threeSum < target {
				l ++
			} else {
				return target
			}
		}
	}

	return closestNum
}

func main() {

}