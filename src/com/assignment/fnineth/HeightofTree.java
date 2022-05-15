package com.assignment.fnineth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HeightofTree {


    public static TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static int height(TreeNode root) {
        // Write your code here.
        if(root==null)
        {
            return -1;
        }
        return 1+Math.max(height(root.left), height(root.right));
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            TreeNode root = null;
            String[] str = br.readLine().split(" ");
            int[] arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(str[i]);
            }

            for(int i=0; i<n; i++)
            {
                root  = insert(root, arr[i]);
            }

            int h = height(root);

            bw.write(h+"\n");

        }

        bw.flush();
        bw.close();
    }
}


