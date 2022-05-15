package com.assignment.bsecond;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WayTooLongWords {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
             String str = br.readLine();
             int len = str.length();
            if (len > 10) {
                char a = str.charAt(0);
                char b = str.charAt(len-1);
                String ans = a+String.valueOf(len-2)+b;
                bw.write(ans+"\n");
            }
            else
            {
                bw.write(str+ "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
