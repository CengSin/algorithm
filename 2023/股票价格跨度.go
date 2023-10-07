package main

import "math"

type pair struct {
	day   int
	price int
}

type StockSpanner struct {
	stack []pair
	day   int
}

func Constructor() StockSpanner {
	return StockSpanner{[]pair{{-1, math.MaxInt}}, -1}
}

func (this *StockSpanner) Next(price int) int {
	for price >= this.stack[len(this.stack)-1].price {
		this.stack = this.stack[:len(this.stack)-1]
	}

	this.day++
	this.stack = append(this.stack, pair{this.day, price})
	return this.day - this.stack[len(this.stack)-2].day
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Next(price);
 */
