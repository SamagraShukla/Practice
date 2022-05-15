package com.assignment.fnineth;

import java.io.*;

/**
 * Given an array of unique elements, construct a Binary Search Tree and print the PreOrder, InOrder and PostOrder Traversals of the tree.
 *
 * Input Format
 *
 * First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.
 *
 * Constraints
 *
 * 1 <= T <= 1000
 * 1 <= N <= 1000
 * 0 <= ar[i] <= 10000
 *
 * Output Format
 *
 * For each test case, print the PreOrder, InOrder and PostOrder Traversals of the Binary Search Tree, separate each traversal by newline. Separate the output of different test cases with an extra newline.
 *
 * Sample Input 0
 *
 * 3
 * 5
 * 1 2 3 4 5
 * 5
 * 3 2 4 1 5
 * 7
 * 4 5 15 0 1 7 17
 * Sample Output 0
 *
 * 1 2 3 4 5
 * 1 2 3 4 5
 * 5 4 3 2 1
 *
 * 3 2 1 4 5
 * 1 2 3 4 5
 * 1 2 5 4 3
 *
 * 4 0 1 5 15 7 17
 * 0 1 4 5 7 15 17
 * 1 0 7 17 15 5 4
 */

public class TreeTraversals {

    public static TreeNode constructBST(TreeNode root, int ele)
    {
        if(root==null)
        {
            return new TreeNode(ele);
        }
        if(ele>root.data)
        {
            root.right = constructBST(root.right, ele);
        }
        else{
            root.left = constructBST(root.left, ele);
        }

        return root;

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
                root  = constructBST(root, arr[i]);
            }

            preOrder(root);
            bw.write("\n");
            System.out.println();
            inOrder(root);
            System.out.println();
            bw.write("\n");
            postOrder(root);
            System.out.println();
            System.out.println();
            bw.write("\n");
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void preOrder(TreeNode root) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(root==null)
        {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(root==null)
        {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }
    public static void inOrder(TreeNode root) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(root==null)
        {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        //bw.write(root.data + " ");
        inOrder(root.right);
    }



}

class TreeNode {
    int data;
    TreeNode right;
    TreeNode left;

    public TreeNode(int data) {
        this.data = data;
        right = null;
        left = null;
    }
}
