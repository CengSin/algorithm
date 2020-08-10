// 滑动窗口的最大值
package main

// 思想，通过维护一个有序队列，如果i>=k-1，则队列中的第一个值就是滑动窗口中的最大值，因为总共的滑动窗口的最大值的个数有n-k
// +1

type Queue []int

func (q Queue) Len() int {
	return len(q)
}

func (q Queue) PeekLast() int {
	if IsEmpty(q) {
		panic("queue is Empty!")
	}
	return q[q.Len()-1]
}

func IsEmpty(q Queue) bool {
	return q == nil || q.Len() <= 0
}

func (q *Queue) PollLast() int {
	if IsEmpty(*q) {
		panic("queue is Empty!")
	}
	val := (*q)[q.Len()-1]
	*q = (*q)[0 : q.Len()-1]
	return val
}

func (q *Queue) AddLast(num int) {
	*q = append(*q, num)
}

func (q Queue) PeekFirst() int {
	if IsEmpty(q) {
		panic("queue is Empty!")
	}
	return q[0]
}

func (q *Queue) PollFirst() int {
	if IsEmpty(*q) {
		panic("queue is Empty!")
	}
	val := (*q)[0]
	*q = (*q)[1:]
	return val
}

func ConstructQueue(k int) *Queue {
	nums := make([]int, 0, k)
	queue := Queue(nums)
	return &queue
}

func maxSlidingWindow(nums []int, k int) []int {
	if nums == nil || k <= 0 || len(nums) < k {
		return nil
	}

	res := make([]int, 0, len(nums)-k+1)

	// 有序队列
	// 如果队列为空，则直接插入队列，
	// 否则，每个入队的值都要与队尾的值进行比较，如果队尾的值大于入队的值，则将值插入队列。
	// 如果队尾的值小于等于入队的值，则弹出队尾的值，循环以上步骤，
	// 如果队头的值的index > i - k + 1,则对头的值弹出（失效）
	queue := ConstructQueue(k)

	for i, num := range nums {
		for queue.Len() != 0 && nums[queue.PeekLast()] <= num {
			queue.PollLast()
		}
		queue.AddLast(i)

		if queue.PeekFirst() == i-k {
			queue.PollFirst()
		}

		if i >= k-1 {
			res = append(res, nums[queue.PeekFirst()])
		}
	}

	return res
}
