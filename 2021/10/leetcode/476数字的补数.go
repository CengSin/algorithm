package leetcode

func findComplement(num int) int {
	var pos int

	for i := 30; i >= 0; i-- {
		if (num & (1 << i)) == 1<<i { // 从最高位开始找第一个1
			pos = i
			break
		}
	}

	for i := pos; i >= 0; i-- {
		num ^= 1 << i // 如果该位为0，则变为1，如果该位为1，则变为0（异或：相同为0，不同为1）
	}

	return num
}
