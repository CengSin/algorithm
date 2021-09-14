package main

import "math"

//findPeakElement 二分查找，寻找数据组中峰值。
// 谷峰，谷底，谷边
// 如果在谷峰，那么直接返回结果即可
// 如果在谷边，那么需要判断。
//    如果nums[mid - 1] > nums[mid] > nums[mid + 1], 那么说明最大值在左边，终止位置 = mid - 1
//    如果nums[mid - 1] < nums[mid] < nums[mid + 1], 那么说明最大值在右边，起始位置 = mid + 1
// 如果在谷底，那么需要抉择
//    谷底的判断为 nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]，如果要求处于谷底时，游标往左移。
//  那么总的公式可以简化为 if nums[mid - 1] > nums[mid]  终止位置 = mid - 1，否则 ，起始位置 = mid + 1
func findPeakElement(nums []int) int {
	n, left, right := len(nums), 0, len(nums)-1
	get := func(i int) int {
		if i >= n || i < 0 {
			return math.MinInt64
		}
		return nums[i]
	}

	for {
		mid := left + (right-left)/2
		if get(mid) > get(mid-1) && get(mid) > get(mid+1) {
			return mid
		}
		if get(mid-1) > get(mid) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
}
