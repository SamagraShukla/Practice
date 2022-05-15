package com.assignment.eeighth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * Given a sentence, reverse the entire sentence word-by-word.
 * Note: Solve using stack or in-place swap. Do not simply scan, split and print in reverse order.
 *
 * Input Format
 *
 * First line of input contains T - number of test cases. Its followed by T lines, each contains a sentence S of space separated words of lowercase english alphabet. All the words are separated by a single space.
 *
 * Constraints
 *
 * 1 <= T <= 1000
 * 1 <= len(S) <= 1000
 *
 * Output Format
 *
 * For each test case, print the reversed sentence, separated by newline.
 *
 * Sample Input 0
 *
 * 3
 * hello world
 * a b c d
 * data structures and algorithms
 * Sample Output 0
 *
 * world hello
 * d c b a
 * algorithms and structures data
 */

public class ReversetheSentence {

    public  static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0)
        {
            String str[] = br.readLine().split(" ");
            Stack<String> stringStack = new Stack<String>();

            for(int i=0; i<str.length; i++) {
                stringStack.push(str[i]);
            }

            for(int i=0; i<str.length; i++) {
                bw.write(stringStack.pop()+" ");
            }
            bw.write("\n");
            t--;

        }

        br.close();
        bw.flush();
        bw.close();
    }
}
