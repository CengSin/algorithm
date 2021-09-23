package main

func isPowerOfThree(n int) bool {
	for n > 0 && n%3 == 0 {
		n /= 3
	}

	return n == 1

	//return n > 0 && int(math.Pow(3, 19)) % n == 0
}
