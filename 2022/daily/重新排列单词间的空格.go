package daily

import (
	"strings"
)

func ReorderSpaces(text string) string {
	return reorderSpaces(text)
}

func reorderSpaces(text string) string {
	chars, spaceNum, charStart := []string{}, 0, -1
	for i, c := range text {
		switch c {
		case ' ':
			spaceNum++
			if charStart != -1 { // 头部处理
				chars = append(chars, text[charStart:i])
				charStart = -1
			}
		default:
			if charStart == -1 {
				charStart = i
			}
		}
	}

	if charStart != -1 { // 结果处理
		chars = append(chars, text[charStart:])
	}

	charsNum := len(chars)

	if spaceNum == 0 { // 空格为0
		return text
	}

	var insideSpaceNum, lastSpaceNum int
	if charsNum == 1 {
		lastSpaceNum = spaceNum
	} else {
		insideSpaceNum, lastSpaceNum = spaceNum/(charsNum-1), spaceNum%(charsNum-1)
	}
	var insideStr string
	for i := 0; i < insideSpaceNum; i++ {
		insideStr += " "
	}
	var endStr string
	for i := 0; i < lastSpaceNum; i++ {
		endStr += " "
	}
	return strings.Join(chars, insideStr) + endStr
}
