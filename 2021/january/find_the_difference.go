package main

func findTheDifference(s string, t string) byte {
	if s == "" {
		return t[0]
	}

	var visit [1001]int

	for _, c := range t {
		visit[c-'a'] += 1
	}

	for _, c := range s {
		visit[c-'a']--
	}

	for i, val := range visit {
		if val != 0 {
			return byte('a' + i)
		}
	}

	return 0
}
