package main

func getSum(a int, b int) int {
	// int(uint(a&b)<<1) 求加法进位
	// a^b 加法无进位的结果
	for b != 0 {
		b, a = int(uint(a&b)<<1), a^b
	}
	return a
}
