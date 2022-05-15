package com.assignment.cfourth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Given an array of integers and a number K, check if there exist a pair of indices i,j s.t. a[i] + a[j] = K and i!=j.
 *
 * Input Format
 *
 * First line of input contains T - number of test cases.
 * Its followed by 2T lines,
 * first line of each test case contains N - size of the array and K,
 * and the next line contains N integers - the elements of the array.
 *
 * Constraints
 *
 * 30 points
 * 1 <= T <= 100
 * 2 <= N <= 1000
 *
 * 70 points
 * 1 <= T <= 300
 * 2 <= N <= 10000
 *
 * General Constraints
 * -108 <= K <= 108
 * -108 <= ar[i] <= 108
 *
 * Output Format
 *
 * For each test case, print "True" if such a pair exists, "False" otherwise, separated by newline.
 *
 * Sample Input 0
 *
 * 3
 * 5 -15
 * -30 15 20 10 -10
 * 2 20
 * 10 10
 * 4 7
 * -4 0 10 -7
 * Sample Output 0
 *
 * True
 * True
 * False
 */


public class SumofPairs {
    public static void main(String arg[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            String str[] = br.readLine().split(" ");
            int len = Integer.parseInt(str[0]);
            int sum = Integer.parseInt(str[1]);

            int ar[] = new int[len];

            String arr[] = br.readLine().split(" ");

            for (int i = 0; i < len; i++) {
                ar[i] = Integer.parseInt(arr[i]);
            }

            Arrays.sort(ar);

            boolean bool = false;
            int p1 = 0, p2 = len - 1;

            for(int i=0; i<len; i++)
            {
                if(SumofPairs(ar, i+1,len-1, sum-ar[i]))
                {
                    bool = true;
                    break;
                }
            }

            int a = Integer.MIN_VALUE;



        }


        br.close();
        bw.flush();
        bw.close();

    }

    public static boolean SumofPairs(int ar[], int lo, int hi, int sum)
    {
        boolean bool =false;
        if(lo>hi)
        {
        return false;}

        int mid = (lo+hi)/2;

        if(ar[mid]==sum)
        {
            return true;
        }

        if(ar[mid]>sum)
        {
            bool = SumofPairs(ar, lo, mid, sum);
        }

        if(ar[mid]<sum)
        {
            bool = SumofPairs(ar, mid, hi, sum);
        }
        return bool;
    }

}
