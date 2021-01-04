package main

// 给定一个数组，和一个数字k，k表示一个滑动窗口的长度。你只能看到窗口中的数字，打印每次看到的窗口值的最大值
func maxSlidingWindow(nums []int, k int) []int {
	if len(nums) == 0 || k < 1 || k > len(nums) {
		return nil
	}

	// 使用的数据结构为双端队列queue
	// 放入规则为：
	//  如果队列queue为空,则直接将数字放入
	// 如果队列不为空，用队列尾部的数字与放入的数字进行对比，如果队列尾部的数字小于放入的数字，则将队列尾部的数字弹出，循环直至放入数字
	// 如果队列头部的下标 == i - w ，说明该数字已经过期，弹出数字

	var queue []int
	var result []int
	for i := range nums {
		for len(queue) != 0 && nums[queue[len(queue)-1]] <= nums[i] {
			queue = queue[:len(queue)-1]
		}
		queue = append(queue, i)

		if queue[0] == i-k {
			queue = queue[1:]
		}

		if i >= k-1 {
			result = append(result, nums[queue[0]])
		}
	}

	return result
}
