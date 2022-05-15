package com.contests.smartinterviews.finalcontest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayZeroSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            int arSize=Integer.parseInt(br.readLine());
            String[] arr=br.readLine().split(" ");
            int ans=0;
            Map<Integer,Integer> ansMap=new HashMap<Integer,Integer>();
            ansMap.put(0,0);
            int sum=0;
            for(int i=0;i<arSize;i++){

                sum=sum+Integer.parseInt(arr[i]);
                if(ansMap.containsKey(sum)){
                    ans=Math.max(ans,(i-ansMap.get(sum)+1));
                }else{
                    ansMap.put(sum,i+1);
                }

            }
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}



