package main

import "fmt"

func commonChars(A []string) []string {
	if len(A) < 2 {
		return A
	}

	visitSign := initVisitMap(A[0])

	for i := 1; i < len(A); i++ {
		tmpSign := initVisitMap(A[i])
		for key, val := range visitSign {
			checkVal, ok := tmpSign[key]
			if !ok {
				delete(visitSign, key)
				continue
			}
			minVal := val
			if val > checkVal {
				minVal = checkVal
			}
			visitSign[key] = minVal
		}
	}

	var result []string
	for key, val := range visitSign {
		for i := 0; i < val; i++ {
			result = append(result, key)
		}
	}
	return result
}

func initVisitMap(s string) map[string]int {
	visit := make(map[string]int, 16)
	for _, c := range s {
		key := string(c)
		if _, ok := visit[key]; !ok {
			visit[key] = 0
		}
		visit[key]++
	}
	return visit
}

func main() {
	result := commonChars([]string{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"})
	fmt.Printf("%+v\n", result)
	//["bella","label","roller"]
	result = commonChars([]string{"bella", "label", "roller"})
	fmt.Printf("%+v\n", result)
}
