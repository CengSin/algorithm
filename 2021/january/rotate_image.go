package main

// 顺时针旋转90度
func rotate(matrix [][]int) {
	var res [][]int
	for i := 0; i < len(matrix); i++ {
		var tmp []int
		for j := len(matrix) - 1; j >= 0; j-- {
			tmp = append(tmp, matrix[j][i])
		}
		res = append(res, tmp)
	}
	copy(matrix, res)
}

func main() {

}
