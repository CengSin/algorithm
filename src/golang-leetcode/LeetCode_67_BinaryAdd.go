package main

import "fmt"

func addBinary(a string, b string) string {
    c := ""
    carry := 0
    lenA, lenB := len(a), len(b)
    count := max(lenA, lenB)

    for i:=0; i < count; i++ {
        if i < len(a) {
            carry += int(a[lenA -i - 1] - '0')
        }
        if i < len(b) {
            carry += int(b[lenB -i - 1] - '0')
        }
        c = strconv.Itoa(carry % 2) + c
        
        carry /= 2
    }

    if carry != 0 {
        c = "1" + c
    }

    return c
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func main() {
	fmt.Println("vim-go")
}
