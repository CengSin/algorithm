package main

import (
	"fmt"
	"strings"
)

func great(s []rune, i, j int) bool {
	return i >= 0 && i <= len(s)-2 && j >= 0 && j <= len(s)-1 && (check(s, i, j) || check(s, j, i)) && (s[i] - 32 == s[j] || s[i] + 32 == s[j])
}

func check(s []rune, i int, j int) bool {
	return s[i] >= 'A' && s[i] <= 'Z' && s[j] >= 'a' && s[j] <= 'z'
}

func makeGood(s string) string {
	if len(s) == 0 {
		return ""
	}
	chars := make([]rune, 0, len(s))
	for _, val := range s {
		chars = append(chars, val)
	}

	for i := 0; i <= len(chars)-2; {
		if great(chars, i, i+1) {
			moveStr(chars, i)
			if len(chars) > 0 {
				chars = chars[0 : len(chars)-2]
			}
			i = 0
		} else {
			i++
		}
	}

	var sb strings.Builder
	for _, char := range chars {
		sb.WriteRune(char)
	}
	return sb.String()
}

func moveStr(char []rune, i int) {
	for start := i; start < len(char)-2; start++ {
		(char)[start] = (char)[start+2]
	}
}

func main() {
	good := makeGood("abBAcC")
	fmt.Println(good)
}
