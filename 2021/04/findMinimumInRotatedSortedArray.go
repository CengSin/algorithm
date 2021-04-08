package main

func findMin(nums []int) int {

	// 排序后拿到最小值
	//sort.Ints(nums)
	//return nums[0]

	start, end := 0, len(nums)-1

	for start < end {
		mid := (start + end) / 2
		if nums[mid] < nums[end] {
			end = mid
		} else {
			start = mid + 1
		}
	}

	return nums[start]
}

func main() {

}
