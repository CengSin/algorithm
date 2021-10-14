package leetcode

func peakIndexInMountainArray(arr []int) int {
	start, end := 0, len(arr)
	for start < end {
		mid := start + (end-start)/2

		if arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1] {
			return mid
		} else if arr[mid] > arr[mid-1] {
			start = mid
		} else {
			end = mid
		}
	}

	return start
}
