package com.assignment.eeighth;

import java.util.Stack;

public class MinStack {




    class Solution {

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();


        public void push(int x) {
            stack.push(x);
            if(minStack.isEmpty()||minStack.peek()>x)
            {
                minStack.push(x);
            }
        }

        public void pop() {


        }

        public int top() {
            int last = 0;// vector.lastElement();
            return last;
        }

        public int getMin() {
            return 1;
            // implement min stack and return

        }
    }
}

