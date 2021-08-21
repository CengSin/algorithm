//给你一个字符数组 chars ，请使用下述算法压缩：
//
// 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
//
//
// 如果这一组长度为 1 ，则将字符追加到 s 中。
// 否则，需要向 s 追加字符，后跟这一组的长度。
//
//
// 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会
//被拆分为多个字符。
//
// 请在 修改完输入数组后 ，返回该数组的新长度。
//
// 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
//
//
//
// 示例 1：
//
//
//输入：chars = [97,97,98,98,"c","c","c"]
//输出：返回 6 ，输入数组的前 6 个字符应该是：[97,"2",98,"2","c","3"]
//解释：
//"aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
//
//
// 示例 2：
//
//
//输入：chars = [97]
//输出：返回 1 ，输入数组的前 1 个字符应该是：[97]
//解释：
//没有任何字符串被替代。
//
//
// 示例 3：
//
//
//输入：chars = [97,98,98,98,98,98,98,98,98,98,98,98,98]
//输出：返回 4 ，输入数组的前 4 个字符应该是：[97,98,"1","2"]。
//解释：
//由于字符 97 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
//注意每个数字在数组中都有它自己的位置。
//
//
//
//
// 提示：
//
//
// 1 <= chars.length <= 2000
// chars[i] 可以是小写英文字母、大写英文字母、数字或符号
//
// Related Topics 双指针 字符串 👍 250 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func compress(chars []byte) int {

	i, j, cnt := 0, 0, 0
	for j < len(chars) {
		var tmp []int
		for j < len(chars) && chars[i] == chars[j] {
			j++
		}

		cnt = j - i
		if cnt == 1 {
			i = j
			continue
		}

		for cnt > 0 {
			tmp = append(tmp, cnt%10)
			cnt /= 10
		}

		for tmpIndex := len(tmp) - 1; tmpIndex >= 0; tmpIndex-- {
			chars[i+1] = '0' + byte(tmp[tmpIndex])
			i++
		}

		move := j - i - 1
		for ; j < len(chars); j++ {
			chars[j-move] = chars[j]
		}
		j = i + 1
		i = j
		chars = chars[:len(chars)-move]
	}

	return len(chars)
}

//leetcode submit region end(Prohibit modification and deletion)
