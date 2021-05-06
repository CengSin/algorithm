package _5

// arr[i+1] = encoded[i] ^ arr[i]
func decode(encoded []int, first int) []int {
	n := len(encoded)
	arr := make([]int, n+1)
	arr[0] = first
	for i := 1; i < n+1; i++ {
		arr[i] = encoded[i - 1] ^ arr[i - 1]
	}

	return arr
}
