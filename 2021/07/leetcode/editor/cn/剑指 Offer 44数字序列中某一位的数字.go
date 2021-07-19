//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。
//
// 请写一个函数，求任意第n位对应的数字。
//
//
//
// 示例 1：
//
// 输入：n = 3
//输出：3
//
//
// 示例 2：
//
// 输入：n = 11
//输出：0
//
//
//
// 限制：
//
//
// 0 <= n < 2^31
//
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
// Related Topics 数学 二分查找
// 👍 147 👎 0

package main

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
func findNthDigit(n int) int {
	if n < 0 {
		return -1
	}

	digits := 1
	for {
		number := countOfInteger(digits)
		if n < digits*number {
			return digitAtIndex(n, digits)
		}

		n -= digits * number
		digits++
	}
}

func digitAtIndex(n, digits int) int {
	num := beginNumber(digits) + n/digits
	indexFromRight := digits - n%digits
	for i := 1; i < indexFromRight; i++ {
		num /= 10
	}
	return num % 10
}

func beginNumber(digits int) int {
	if digits == 1 {
		return 0
	}

	return int(math.Pow(10, float64(digits-1)))
}

func countOfInteger(digits int) int {
	if digits == 1 {
		return 10
	}
	return 9 * int(math.Pow(10, float64(digits-1)))
}

//leetcode submit region end(Prohibit modification and deletion)
