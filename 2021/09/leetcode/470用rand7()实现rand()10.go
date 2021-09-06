package main

func rand10() int {
	for {
		num := (rand7()-1)*7 + rand7()
		if num <= 40 { // 最差情况为正无穷
			return num%10 + 1
		}

		a := num - 40 // rand9()
		b := rand7()
		num = (a-1)*7 + b // rand63()
		if num <= 60 {
			return num%10 + 1
		}

		a = num - 60
		b = rand7()
		num = (a-1)*7 + b // rand21()
		if num <= 20 {
			return num%10 + 1
		}
	}
}
