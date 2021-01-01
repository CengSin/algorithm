package january

func twoSum(nums []int, target int) []int {
	visit := make(map[int]int)

	for i, num := range nums {
		visit[num] = i
	}

	var result []int

	for i := 0; i < len(nums); i++ {
		if val, exist := visit[target-nums[i]]; exist && val != i {
			result = append(result, val, i)
			break
		}
	}
	return result
}
