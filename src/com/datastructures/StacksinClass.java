package com.datastructures;

import java.util.Stack;

public class StacksinClass {
    public static void main(String Args[])
    {
        Stack<Integer> stack = new Stack<Integer>();

//        System.out.println(stack.peek());   // empty stack exception
        stack.add(1);
        stack.add(2);

        System.out.println(stack.capacity());

        System.out.println(stack.peek());
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.add(6);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        if(!stack.isEmpty())
        {System.out.println(stack.pop());}
        if(!stack.isEmpty())
        {System.out.println(stack.pop());}

        System.out.println(stack.contains(2));

        System.out.println(stack.push(2));

        System.out.println(stack.add(10));
        System.out.println(stack.add(10));
        System.out.println(stack.add(10));
        System.out.println(stack.add(10));
        System.out.println(stack.add(10));
        System.out.println(stack.add(10));

        System.out.println(stack.capacity());
    }
}
