package main

// 下标i处能接到的最大水的数量 = i两边中最小的值 - i本身的值
// 分两次循环分别记录i左边的最大值和右边的最大值 leftMax[0] = rightMax[0] leftMax[n-1] = rightMax[n - 1]
// i处能接水的值 = min(left[i], right[i]) - height[i]
func trap(height []int) int {
	n := len(height)
	if n == 0 {
		return 0
	}
	leftMax, rightMax := make([]int, n), make([]int, n)
	leftMax[0], rightMax[0], leftMax[n-1], rightMax[n-1] = height[0], height[0], height[n-1], height[n-1]

	for i := 1; i < n; i++ {
		leftMax[i] = max(leftMax[i-1], height[i])
	}

	for i := n - 2; i >= 0; i-- {
		rightMax[i] = max(rightMax[i+1], height[i])
	}

	var result int

	for i := 0; i < n; i++ {
		result += min(leftMax[i], rightMax[i]) - height[i]
	}

	return result
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	print(trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
}
