package com.assignment.eeighth;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;
//import java.util.Stack;

/**
 * Perform push and pop operations on stack. Implement Stacks and avoid using inbuilt library.
 *
 * Input Format
 *
 * First line of input contains T - number of operations. Its followed by T lines, each line contains either "push x" or "pop".
 *
 * Constraints
 *
 * 1 <= T <= 10000
 * -100 <= x <= 100
 *
 * Output Format
 *
 * For each "pop" operation, print the popped element, separated by newline. If the stack is empty, print "Empty".
 *
 * Sample Input 0
 *
 * 8
 * push 5
 * pop
 * pop
 * push 10
 * push -15
 * pop
 * push -10
 * pop
 * Sample Output 0
 *
 * 5
 * Empty
 * -15
 * -10
 */


public class ImplementStack {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcases = Integer.parseInt(br.readLine());

//        Stack<Integer> stack = new Stack<Integer>();

        Stack stack = new Stack();

        while(testcases>0)
        {
            String[] str = br.readLine().split(" ");
//            bw.write(str[0] + "\n");

            if (str[0].equals("pop")) {
                if(stack.isEmpty())
                {
                    bw.write("Empty\n");
                }else
                {
                    bw.write(stack.pop()+"\n");
                }
            }
            if(str[0].equals("push"))
            {
                int ele = Integer.parseInt(str[1]);
                stack.push(ele);
            }


            testcases--;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Stack {
//        private int top;    //pointer not the value
//        private int max;
        private Vector<Integer> vector;
        HashSet<Integer> hashSet;
//        private int size;

        Stack()
        {
            vector = new Vector<Integer>();
            hashSet = new HashSet<Integer>();
        }

        public int getMax() {
            Object obj = Collections.max(hashSet);
            String m = obj+"";
            return Integer.parseInt(m);
        }

        public int peek() {
            int last = vector.lastElement();
            vector.remove(vector.size()-1);
            return last;
        }

        public boolean isEmpty(){
            return vector.isEmpty();
        }

        public int push(int x)
        {
            vector.addElement(x);
            hashSet.add(x);
            return vector.lastElement();
        }

        public int pop()
        {
            int last = vector.lastElement();
            hashSet.remove(last);
            vector.removeElementAt(vector.size()-1);
            return last;
        }


    }
}
