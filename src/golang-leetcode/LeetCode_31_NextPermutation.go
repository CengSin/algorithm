package main

// nextPermutation 下一个更大的序列
func nextPermutation(nums []int) {
	n := len(nums)
	if n == 0 {
		return
	}
	i := n - 2
	// 找到第一个满足a[i] < a[i+1]的数字
	for i >= 0 && nums[i] >= nums[i+1] {
		i--
	}
	// 如果找到i的位置，则从i的位置往后开始查找第一个比nums[i]大的数字并交换位子
	if i >= 0 {
		j := n - 1
		for j >= 0 && nums[i] >= nums[j] {
			j--
		}
		nums[i], nums[j] = nums[j], nums[i]
	}
	// 交换i+1到结尾的数字
	reverse(nums[i+1:])
}

func reverse(nums []int) {
	for i, n := 0, len(nums); i < n/2; i++ {
		nums[i], nums[n-i-1] = nums[n-i-1], nums[i]
	}
}

func main() {

}
