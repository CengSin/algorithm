package main

func findMinII(nums []int) int {
	//sort.Ints(nums)
	//return nums[0]

	start, end := 0, len(nums)-1

	for start+1 < end {

		mid := (start + end) / 2

		if nums[mid] < nums[end] {
			end = mid
		} else if nums[mid] > nums[end] {
			start = mid + 1
		} else {
			end--
		}

	}

	return min(nums[start], nums[end])
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {

}
