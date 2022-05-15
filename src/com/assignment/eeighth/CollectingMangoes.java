package com.assignment.eeighth;

import java.io.*;
import java.util.Vector;

/**
 * One day after storm Mina went to pick up mangoes in the garden with a basket. She began to pick up mangoes from the garden.
 * And if she wants, she can throw away the last picked up mango from the basket. In this way, Mina kept picking up mangoes.
 * She brought you with her to keep track of the biggest size of mango in the basket at that time.
 * At any moment Mina can ask you about the biggest size of mango. Your job is to help Mina.
 *
 * Since you are a good programmer, so you write a program by which you are easily able to answer the question of Mina.
 * During picking up mangoes, Mina can have 3 types of question/instruction for you.
 *
 * Type 1: Put an "x" size mango in the basket, which is picked up form garden.
 *
 * Type 2: Throw out last picked up mango.
 *
 * Type 3: Ask for the biggest mango size in the basket at that moment.
 *
 * Input Format
 *
 * First line of input contains T - number of test cases.
 * Each case start with a positive integer N, which is number of question/operation Mina will ask during picking up mangoes.
 * Next N lines will contain 3 types of operations (A, R, Q):
 * A x (here x is picked up mango size),
 * R (Throw out last picked up mango from basket),
 * Q (Find out the biggest size mango).
 *
 * Please use fast IO due to large size of input/ouptut.
 *
 * Constraints
 *
 * 30 points
 * 1 <= T <= 100
 * 1 <= N <= 1000
 * 1 <= x <= 100000
 *
 * 70 points
 * 1 <= T <= 100
 * 1 <= N <= 100000
 * 1 <= x <= 100000
 *
 * Output Format
 *
 * For each test case, first print the case number and print the answer to each of Mina's questions (Queries of Type 3 - Q).
 * Whenever the basket is empty, then Mina's question's answer will be "Empty".
 *
 * Sample Input 0
 *
 * 2
 * 7
 * A 10
 * A 5
 * Q
 * A 100
 * Q
 * R
 * Q
 *
 * 6
 * A 5
 * Q
 * R
 * Q
 * R
 * R
 * Sample Output 0
 *
 * Case 1:
 * 10
 * 100
 * 10
 * Case 2:
 * 5
 * Empty
 */

public class CollectingMangoes {




public static void main(String args[]) throws Exception
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testcases = Integer.parseInt(br.readLine());
    int c=1;
    while(testcases>0)
    {


        Stack stack = new Stack();
        Stack stackMax = new Stack();
        bw.write("Case "+c+":\n");
        c++;
        int N = Integer.parseInt(br.readLine());
        while(N>0) {
            String[] str = br.readLine().split(" ");
            String a = str[0];
            int b = 0;
            if(a.equals("A")) {
                b = Integer.parseInt(str[1]);
            }
            //bw.write(str[0] + "\n");

            /** A x (here x is picked up mango size),
             * R (Throw out last picked up mango from basket),
             * Q (Find out the biggest size mango).*/

            switch (a) {
                case "R":
                    if (stack.isEmpty()) {
                        //bw.write("Empty\n");
                        break;
                    } else {
//                            bw.write(stack.pop() + "\n");
                        int popped = stack.pop();
                        if(stackMax.peek()==popped) {
                            stackMax.pop();
                        }
                        break;
                    }

                case "A":
                    stack.push(b);
                    if(stackMax.isEmpty()|| stackMax.peek()<=b)
                    {
                        stackMax.push(b);
                    }

                    break;

                case "Q":
                    if (stackMax.isEmpty()) {
                        bw.write("Empty\n");
                        break;
                    } else {
                        bw.write(stackMax.peek()+"\n");
                        break;
                    }

                default: break;
            }

            N--;
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
//        private int size;

        Stack()
        {
            vector = new Vector<Integer>();
        }

        public int getMax() {
//            int max = Collections.max(vector);
            int max = 0;

            for(int i=0; i<vector.size();i++)
            {
                if(max< vector.elementAt(i))
                {
                    max = vector.elementAt(i);
                }
            }
            return max;
        }

        public int peek() {
            int last = vector.lastElement();
            vector.get(vector.size()-1);
            return last;
        }

        public boolean isEmpty(){
            return vector.isEmpty();
        }

        public int push(int x)
        {
            vector.addElement(x);
            return vector.lastElement();
        }

        public int pop()
        {
            int last = vector.lastElement();
            vector.removeElementAt(vector.size()-1);
            return last;
        }


    }






    //
//// first code:
//
//    public static void main(String[] args) throws IOException {
//        InputStreamReader isr=new InputStreamReader(System.in);
//        BufferedReader br=new BufferedReader(isr);
//
//        OutputStreamWriter osr=new OutputStreamWriter(System.out);
//        BufferedWriter bw=new BufferedWriter(osr);
//
//        int testCase=Integer.parseInt(br.readLine());
//        int i=1;
//
//        while(testCase>0){
//            int operations = Integer.parseInt(br.readLine());
//            bw.write("Case "+i+":\n");
//            i++;
//            Stack<Integer> stackOrder=new Stack<Integer>();
//            Stack<Integer> maximumStack=new Stack<Integer>();
//            //int maximumElement=-1;  // can not maintisan local variable as I don't know hat all maximum elements i have donw the line
//
//            while(operations>0){
//                String[] oprInput=br.readLine().split(" ");
//                int valToPush=0;
//
//                if(oprInput.length>1){
//                    valToPush=Integer.parseInt(oprInput[1]);
//                }
//
//                if(oprInput[0].equals("A")){
//                    stackOrder.push(valToPush);
//                    if(maximumStack.isEmpty()){
//                        maximumStack.push(valToPush);
//                    }else{
//                        if(maximumStack.peek()<=valToPush){
//                            maximumStack.push(valToPush);
//                        }
//                    }
//                }else if(oprInput[0].equals("R")){
//                    if(maximumStack.isEmpty()){
//                        //bw.write("Empty\n");
//                    }else{
//                        int result=stackOrder.pop();
//                        if(maximumStack.peek()==result){
//                            maximumStack.pop();
//                        }
//                    }
//                }else{
//                    if(maximumStack.isEmpty()){
//                        bw.write("Empty\n");
//                    }else{
//                        bw.write(maximumStack.peek()+"\n");
//                    }
//                }
//                operations--;
//            }
//
//            testCase--;
//        }
//        bw.flush();
//        br.close();
//        br.close();
//    }

}

