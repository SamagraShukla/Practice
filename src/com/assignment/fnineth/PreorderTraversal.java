package com.assignment.fnineth;

import java.util.*;

class Node {
        TreeNode left;
        TreeNode right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class PreorderTraversal {

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

        public static void preOrder(TreeNode root) {
            if(root==null)
            {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void postOrder(TreeNode root) {
            if(root==null)
            {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");

        }

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

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            TreeNode root = null;
            while(t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            scan.close();
            preOrder(root);
        }
    }
