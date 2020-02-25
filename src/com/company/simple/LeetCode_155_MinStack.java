package com.company.simple;

import java.util.Arrays;

class MinStack {

    private int[] val;

    private final static int DEFAULT_LENGTH = 1000;

    private final static int ENLARGE_SIZE = 100;

    private int size;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        size = 0;
        val = new int[DEFAULT_LENGTH];
    }

    public void push(int x) {
        if (size + 1 >= DEFAULT_LENGTH) {
            val = enlarge(val);
        }

        val[size++] = x;
    }

    private int[] enlarge(int[] val) {
        return Arrays.copyOf(val, val.length + ENLARGE_SIZE);
    }

    public void pop() {
        val[size] = 0;
        size --;
    }

    public int top() {
        return val[size - 1];
    }

    public int getMin() {
        int minNum = val[0];
        for (int i = 0; i < size; i++) {
            if (minNum > val[i]) {
                minNum = val[i];
            }
        }
        return minNum;
    }
}

public class LeetCode_155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert minStack.getMin() == -3;
        minStack.pop();
        assert minStack.top() == 0;
        assert minStack.getMin() == -2;
    }

}
