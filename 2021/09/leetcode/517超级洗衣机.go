package main

func findMinMoves(machines []int) (移动次数 int) {
	衣服总和 := 0
	for _, 每个洗衣机里的衣服个数 := range machines {
		衣服总和 += 每个洗衣机里的衣服个数
	}

	洗衣机的个数 := len(machines)
	if 衣服总和%洗衣机的个数 != 0 {
		return -1
	}

	最大 := func(甲, 乙 int) int {
		if 甲 > 乙 {
			return 甲
		}
		return 乙
	}

	绝对值 := func(数 int) int {
		if 数 < 0 {
			return -数
		}
		return 数
	}

	每个洗衣机里平均应该放的衣服 := 衣服总和 / 洗衣机的个数
	总共需要移动的衣服 := 0
	for _, 洗衣机里本来有的衣服 := range machines {
		需要移动的衣服 := 洗衣机里本来有的衣服 - 每个洗衣机里平均应该放的衣服
		总共需要移动的衣服 += 需要移动的衣服
		移动次数 = 最大(移动次数, 最大(绝对值(总共需要移动的衣服), 需要移动的衣服))
	}

	return
}
