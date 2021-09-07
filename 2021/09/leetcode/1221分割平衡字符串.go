package main

func balancedStringSplit(s string) (ans int) {
	sum := 0
	for _, c := range s {
		switch c {
		case 'L':
			sum += 1
		case 'R':
			sum -= 1
		}
		if sum == 0 {
			ans++
		}
	}
	return
}
