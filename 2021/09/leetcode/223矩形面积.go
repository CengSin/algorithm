package main

func computeArea(ax1 int, ay1 int, ax2 int, ay2 int, bx1 int, by1 int, bx2 int, by2 int) int {
	area := (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1)

	max := func(a, b int) int {
		if a > b {
			return a
		}
		return b
	}
	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	overLapWidth := max(0, min(ax2, bx2)-max(ax1, bx1))
	overLapHeight := max(0, min(ay2, by2)-max(ay1, by1))
	return area - overLapWidth*overLapHeight
}
