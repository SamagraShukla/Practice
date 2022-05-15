package com.contests.smartinterviews.finalcontest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class OptimalTicketSeller {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            String str[] = br.readLine().split(" ");
            int ctr = Integer.parseInt(str[0]);
            int tickets = Integer.parseInt(str[1]);

            int ar[] = new int[ctr];
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

            String str2[] = br.readLine().split(" ");

            for(int i=0; i<ctr ; i++)
            {
                ar[i] = Integer.parseInt(str2[i]);
                priorityQueue.add(ar[i]);

            }

//            Arrays.sort(ar);
//
//
//            for(int i=0; i<ctr ; i++)
//            {
//                priorityQueue.add(ar[i]);
//            }

            int maxsum = 0;
            while(tickets-->0)
            {
                int max = priorityQueue.poll();
                maxsum = maxsum +max;
                priorityQueue.add(max-1);



//                int max = findMax(ar);
//
//                maxsum = maxsum + ar[max];
//                ar[max]--;


//                if(ar[max]<ar[max-1])
//                {
//                    maxsum = maxsum + ar[max-1];
//                    ar[max-1]--;
//                    Arrays.sort(ar);
//                }
//                else
//                {
//                    maxsum = maxsum + ar[max];
//                    ar[max]--;
//                }
            }

            bw.write(maxsum+"\n");


        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int findMax(int ar[])
    {
        int max = 0;
        for(int i=0; i< ar.length; i++)
        {
            if(ar[i]>ar[max])
            {
                max = i;
            }
        }
        return max;
    }


}
