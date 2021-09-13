package main

func numberOfBoomerangs(points [][]int) (ans int) {
	for _, p := range points {
		cnt := make(map[int]int)
		for _, q := range points {
			dis := (p[0]-q[0])*(p[0]-q[0]) + (p[1]-q[1])*(p[1]-q[1])
			cnt[dis]++
		}

		for _, i := range cnt {
			ans += i * (i - 1)
		}
	}

	return ans
}
