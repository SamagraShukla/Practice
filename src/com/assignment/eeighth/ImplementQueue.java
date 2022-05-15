package com.assignment.eeighth;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Perform Enqueue and Dequeue operations on a queue. Implement Queue and avoid using inbuilt library.
 *
 * Input Format
 *
 * First line of input contains T - number of operations. Its followed by T lines, each line contains either "Enqueue x" or "Dequeue".
 *
 * Constraints
 *
 * 1 <= T <= 10000
 * -100 <= x <= 100
 *
 * Output Format
 *
 * For each "Dequeue" operation, print the dequeued element, separated by newline. If the queue is empty, print "Empty".
 *
 *
 * Sample Input 0
 *
 * 8
 * Enqueue 5
 * Dequeue
 * Dequeue
 * Enqueue 10
 * Enqueue -15
 * Dequeue
 * Enqueue -10
 * Dequeue
 * Sample Output 0
 *
 * 5
 * Empty
 * 10
 * -15
 */

public class ImplementQueue {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcases = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<Integer>();

        while(testcases>0)
        {
            String[] str = br.readLine().split(" ");
//            bw.write(str[0] + "\n");

            if (str[0].equals("Dequeue")) {
                if(queue.isEmpty())
                {
                    bw.write("Empty\n");
                }else
                {
                    bw.write(queue.remove()+"\n");
                }
            }
            if(str[0].equals("Enqueue"))
            {
                int ele = Integer.parseInt(str[1]);
                queue.add(ele);
            }


            testcases--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
