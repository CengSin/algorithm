package main

// 种花问题，相邻的土地不能种两朵花
func canPlaceFlowers(flowerbed []int, n int) bool {
	for i := 0; i < len(flowerbed); i += 2 {
		if flowerbed[i] == 0 {
			if i == len(flowerbed)-1 || flowerbed[i+1] != 1 {
				n--
				if n == 0 {
					return true
				}
			} else {
				i++
			}
		}
	}
	return n <= 0
}
