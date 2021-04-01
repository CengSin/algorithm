package main

import (
	"fmt"
	"go/ast"
	"go/parser"
	"go/token"
	"strconv"
	"strings"
)

var ClumsyOperate = []string{"*", "/", "+", "-"}

// 考虑加减乘除的优先级
func clumsy(N int) int {
	//return clumsyByAst(N)

	return clumsyByCalc(N)
}

// 加减法直接配合操作入栈，乘除法直接与栈顶元素计算，最后将栈中的元素相加
func clumsyByCalc(N int) int {
	if N <= 0 {
		return N
	}
	stack := []int{N}

	index := 0
	N -= 1
	for N > 0 {
		switch index {
		case 0:
			stack[len(stack)-1] *= N
		case 1:
			stack[len(stack)-1] /= N
		case 2:
			stack = append(stack, N)
		case 3:
			stack = append(stack, -N)
		}

		N--
		index = (index+1)%4
	}

	for _, val := range stack {
		N += val
	}
	return N
}

func clumsyByAst(N int) int {
	index := 0
	var sb strings.Builder
	sb.WriteString(strconv.Itoa(N))
	for i := N - 1; i > 0; i-- {
		ope := ClumsyOperate[index%4]
		sb.WriteString(ope)
		sb.WriteString(strconv.Itoa(i))
		index += 1
	}
	expr, _ := parser.ParseExpr(sb.String())
	return Eval(expr)
}

func Eval(expr ast.Expr) int {
	switch exp := expr.(type) {
	case *ast.BinaryExpr:
		return EvalBinaryExpr(exp)
	case *ast.BasicLit:
		f, _ := strconv.Atoi(exp.Value)
		return f
	}
	return 0
}

func EvalBinaryExpr(exp *ast.BinaryExpr) int {
	switch exp.Op {
	case token.ADD:
		return Eval(exp.X) + Eval(exp.Y)
	case token.MUL:
		return Eval(exp.X) * Eval(exp.Y)
	case token.SUB:
		return Eval(exp.X) - Eval(exp.Y)
	case token.QUO:
		return Eval(exp.X) / Eval(exp.Y)
	}
	return 0
}

func main() {
	fmt.Println(clumsy(4))
	fmt.Println(clumsy(10))
	fmt.Println(clumsy(7))
}
