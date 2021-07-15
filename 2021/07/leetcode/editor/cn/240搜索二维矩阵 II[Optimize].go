package main

// 二维数组中右边一定大于左边
// 下面一定大于上面
func searchMatrixOptimize(matrix [][]int, target int) bool {
	col, row := 0, len(matrix)-1
	for row >= 0 && col < len(matrix[0]) {
		if matrix[row][col] > target {
			row--
		} else if matrix[row][col] < target {
			col++
		} else {
			return true
		}
	}
	return false
}
