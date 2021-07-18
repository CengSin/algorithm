package main

func kthSmallestOptimize(matrix [][]int, k int) int { // 通过确定最大值和最小值的范围，将范围中的值看作数组，将比mid的值与k比较。
	row, col := len(matrix), len(matrix[0])
	min, max := matrix[0][0], matrix[row-1][col-1]

	for min < max {
		mid := int(uint(min+max) >> 1)
		if check(matrix, mid, k, row) {
			max = mid
		} else {
			min = mid + 1
		}
	}
	return min
}

func check(matrix [][]int, mid, k, row int) bool {
	i, j := row-1, 0
	num := 0 // count of less than mid

	for i >= 0 && j < row {
		if matrix[i][j] <= mid {
			num += i + 1
			j++
		} else {
			i--
		}
	}
	return num >= k
}
