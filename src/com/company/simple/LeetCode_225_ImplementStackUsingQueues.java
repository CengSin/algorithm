package com.company.simple;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 用队列实现栈
 * @author: 15262
 * @date: 2020/3/1
 * <p>
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

class MyStack {

    private Queue<Integer> queue;


    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new PriorityQueue<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return getLastIndex(true);
    }

    private int getLastIndex(boolean isDelete) {
        int[] tmpArr = new int[queue.size()];
        int i = 0;
        while (queue.size() > 0) {
            tmpArr[i++] = queue.poll();
        }
        int index = isDelete ? tmpArr.length - 1 : tmpArr.length;
        for (int j = 0; j < index; j++) {
            queue.offer(tmpArr[j]);
        }

        return tmpArr.length - 1 >= 0 ? tmpArr[tmpArr.length - 1] : 0;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return getLastIndex(false);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue == null || queue.size() == 0;
    }
}

public class LeetCode_225_ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);

        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

}
