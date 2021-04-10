package main

var f = []int{2, 3, 5}

func isUgly(n int) bool {
	if n <= 0 {
		return false
	}

	for _, i := range f {
		for n%i == 0 {
			n /= i
		}
	}

	return n == 1
}

func main() {

}
