package leetcode

func majorityElement(nums []int) (ans []int) {
	i := len(nums) / 3
	visit := make(map[int]int)
	for _, num := range nums {
		visit[num]++
	}

	for k, v := range visit {
		if v > i {
			ans = append(ans, k)
		}
	}

	return
}
