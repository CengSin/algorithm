package main

func maxProfit(prices []int) int {
	buy1, sell1 := -prices[0], 0
	buy2, sell12 := -prices[0], 0

	for i := 1; i < len(prices); i++ {
		buy1 = max(buy1, -prices[i])
		sell1 = max(sell1, buy1+prices[i])
		buy2 = max(buy2, sell1-prices[i])
		sell12 = max(sell12, buy2+prices[i])
	}

	return sell12
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
