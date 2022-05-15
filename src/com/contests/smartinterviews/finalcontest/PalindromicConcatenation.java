package com.contests.smartinterviews.finalcontest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PalindromicConcatenation {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String str[] = br.readLine().split(" ");

            char[] str1 = str[0].toCharArray();
            char[] str2 = str[1].toCharArray();

            int ar[] = new int[26];
//            for(int i=0; i<26; i++)
//            {
//                bw.write(ar[i]+ "\t");
//            }

            for (char a: str1) {
                ar[a-97]++;
            }
            boolean bool = true;
            for(char c: str2) {
                if(ar[c-97]>0)
                {
                    bw.write("Yes\n");
                    bool = false;
                    break;
                }
            }
            if(bool)
            {
                bw.write("No\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }


}
