//在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
//
//
//
// 注意：n 是正数且在 32 位整数范围内（n < 231）。
//
//
//
// 示例 1：
//
//
//输入：3
//输出：3
//
//
// 示例 2：
//
//
//输入：11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
//
// Related Topics 数学 二分查找
// 👍 164 👎 0

package main

import (
	"math"
	"strconv"
)

//leetcode submit region begin(Prohibit modification and deletion)
func findNthDigit(n int) int {
	if n < 10 {
		return n
	}

	getLen := func(x int) int {
		if x == 0 {
			return 0
		}

		l := len(strconv.Itoa(x))
		sum := 0
		for i := 0; i < l; i++ {
			sum += int(math.Pow(10, float64(i)))
		}
		return x*l + l - sum
	}

	left, right := 0, math.MaxInt32-1
	for left < right {
		mid := int(uint(left+right) >> 1)
		l := getLen(mid) // 获取mid构成[0, mid]的字符串长度
		if l < n {
			left = mid + 1
		} else if l > n {
			right = mid
		} else {
			return mid % 10
		}
	}

	ll := getLen(left) - n
	leftStr := strconv.FormatInt(int64(left), 10)
	return int(leftStr[len(leftStr)-1-ll] - '0')
}

//leetcode submit region end(Prohibit modification and deletion)
