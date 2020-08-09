package main

import "fmt"

var (
	str = []string{"0", "0", "011", "0111001", "011100110110001"}
)

func findKthBit(n int, k int) byte {
	if n <= 4 {
		return getK(str[n], k)
	}
	for i := 4; i <= n; i++ {
		str = append(str, str[i] + "1" + get(str[i]))
	}
	return getK(str[n], k)
}

func get(s string) string {
	res := ""
	for i := len(s) - 1; i >= 0; i-- {
		if s[i] == '1' {
			res += "1"
		} else if s[i] == '0' {
			res += "0"
		}
	}
	return res
}

func getK(s string, k int) byte {
	var res byte
	for i, val := range s {
		if i == k - 1 {
			if val == '0' {
				res = 0
			} else {
				res = 1
			}
			break
		}
	}
	return res
}

func main() {
	fmt.Println(findKthBit(1, 1))
	fmt.Println(findKthBit(2, 3))
	fmt.Println(findKthBit(4, 11))
	fmt.Println(findKthBit(3, 1))
}