package com.contests.smartinterviews.finalcontest;

import java.awt.font.OpenType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class RangeQueries {

    static class Pair{
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-->0)
        {
            String str1[] = br.readLine().split(" ");

            int n = Integer.parseInt(str1[0]);  // length of array
            int k = Integer.parseInt(str1[1]);  // range of ele in array

            String str2[] = br.readLine().split(" ");   // ele of array

            int ar[] = new int[n];

            for(int i=0; i<n; i++)
            {
                ar[i] = Integer.parseInt(str2[i]);
            }

            int q = Integer.parseInt(br.readLine());

            ArrayList<Pair> arrayList = new ArrayList();

            while(q-->0)
            {
                String inp[] = br.readLine().split(" ");
                Pair pair = new Pair(Integer.parseInt(inp[0]),Integer.parseInt(inp[1]));
                arrayList.add(pair);
            }

            Arrays.sort(ar);

            for (Pair p: arrayList)
            {
                int low = lowerEnd(ar, n, p.getA());
                int high = upperEnd(ar, n, p.getB());

                int loele = ar[low], hiele = ar[high];

                while(loele >= ar[low])
                {
                    low--;
                }
                while(hiele<= ar[high])
                {
                    high++;
                }
                low++;
                high--;

                bw.write(high-low+1 +"\n");
            }




        }



        br.close();
        bw.flush();
        bw.close();

    }

    static int lowerEnd(int ar[], int n, int q )    //ceil
    {
        int lo=0, hi= n-1, ans = n;

        while(lo<=hi)
        {
            if(ar[hi]<q){
                break;
            }
            int mid = (lo+hi)/2;
            if(ar[mid]>=q)
            {
                ans = mid;
                hi = mid -1;
            }
            else
            {
                lo = mid+1;
            }
        }
        return ans;
    }

    static int upperEnd(int ar[], int n, int q )    //floor
    {
        int lo=0, hi= n-1, ans = 0;

        while(lo<=hi)
        {
            if(ar[lo]>q){
                break;
            }
            int mid = (lo+hi)/2;
            if(ar[mid]<=q)
            {
                ans = mid;
                lo = mid +1;
            }
            else
            {
                hi = mid-1;
            }
        }
        return ans;
    }


}
