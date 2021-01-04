package main

func maxArea(height []int) int {

	max, start, end := 0, 0, len(height)

	for start < end {
		high := 0
		if height[start] < height[end] {
			high = height[start]
			start++
		} else {
			high = height[end]
			end--
		}

		if max <= high*(end-start) {
			max = high * (end - start)
		}
	}

	return max
}
