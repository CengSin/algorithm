package main

//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。
//
// 注意：
//0 ≤ x, y < 231.
//
// 示例:
//
//
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
//
// Related Topics 位运算
// 👍 458 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
func hammingDistance(x int, y int) int {
	result := 0

	for x != 0 || y != 0 {
		x1, y1 := 0, 0
		if x != 0 {
			x1 = x & 1
			x >>= 1
		}
		if y != 0 {
			y1 = y & 1
			y >>= 1
		}

		if x1 != y1 {
			result++
		}
	}

	return result
}

//leetcode submit region end(Prohibit modification and deletion)
