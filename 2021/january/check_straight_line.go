package main

// note: (y1-y0)/(x1-x0)=(yi-y0)/(xi-x0)
func checkStraightLine(coordinates [][]int) bool {
	deltaX, deltaY := coordinates[0][0], coordinates[0][1]
	for _, p := range coordinates {
		p[0] -= deltaX
		p[1] -= deltaY
	}
	A, B := coordinates[1][1], -coordinates[1][0]
	for _, p := range coordinates[2:] {
		x, y := p[0], p[1]
		if A*x+B*y != 0 {
			return false
		}
	}
	return true
}
