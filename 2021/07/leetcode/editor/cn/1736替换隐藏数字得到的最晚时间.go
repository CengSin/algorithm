//给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
//
// 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
//
// 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
//
//
//
// 示例 1：
//
//
//输入：time = "2?:?0"
//输出："23:50"
//解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
//
//
// 示例 2：
//
//
//输入：time = "0?:3?"
//输出："09:39"
//
//
// 示例 3：
//
//
//输入：time = "1?:22"
//输出："19:22"
//
//
//
//
// 提示：
//
//
// time 的格式为 hh:mm
// 题目数据保证你可以由输入的字符串生成有效的时间
//
// Related Topics 字符串
// 👍 37 👎 0

package main

//leetcode submit region begin(Prohibit modification and deletion)
func maximumTime(time string) string {
	var hour, minutes string
	if time[0] == '?' {
		if time[1] == '?' {
			hour = "23"
		} else {
			if time[1] >= '4' {
				hour = "1" + string(time[1])
			} else {
				hour = "2" + string(time[1])
			}
		}
	} else {
		if time[1] == '?' {
			if time[0] < '2' {
				hour = string(time[0]) + "9"
			} else {
				hour = string(time[0]) + "3"
			}
		} else {
			hour = string(time[0]) + string(time[1])
		}
	}

	if time[3] == '?' {
		if time[4] == '?' {
			minutes = "59"
		} else {
			minutes = "5" + string(time[4])
		}
	} else {
		if time[4] == '?' {
			minutes = string(time[3]) + "9"
		} else {
			minutes = string(time[3]) + string(time[4])
		}
	}
	return hour + ":" + minutes
}

//leetcode submit region end(Prohibit modification and deletion)
