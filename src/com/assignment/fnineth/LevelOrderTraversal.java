package com.assignment.fnineth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.logging.Level;

/**
 * Given a pointer to the root of a binary tree, you need to print the level order traversal of this tree. In level-order traversal, nodes are visited level by level from left to right. Complete the function  and print the values in a single line separated by a space.
 *
 * For example:
 *
 *      1
 *       \
 *        2
 *         \
 *          5
 *         /  \
 *        3    6
 *         \
 *          4
 * For the above tree, the level order traversal is .
 *
 * Input Format
 *
 * You are given a function,
 *
 * void levelOrder(Node * root) {
 *
 * }
 * Constraints
 *
 *  Nodes in the tree
 *
 * Output Format
 *
 * Print the values in a single line separated by a space.
 *
 * Sample Input
 *
 *      1
 *       \
 *        2
 *         \
 *          5
 *         /  \
 *        3    6
 *         \
 *          4
 * Sample Output
 *
 * 1 2 5 3 6 4
 *
 * Explanation
 *
 * We need to print the nodes level by level. We process each level from left to right.
 * Level Order Traversal: .
 *
 *
 *
 * Input (stdin)
 *
 * Download
 * 6
 * 1 2 5 3 6 4
 * Your Output (stdout)
 * 1 2 5 3 6 4
 * Expected Output
 *
 * Download
 * 1 2 5 3 6 4
 *
 *
 */


class LevelTreeNode {
    int data;
    int depth;
    int verticalLevel;
    LevelTreeNode right;
    LevelTreeNode left;

    public LevelTreeNode(int data) {
        this.data = data;
        right = null;
        left = null;
    }

    public LevelTreeNode(int data, int height) {
        this.data = data;
        this.depth = height;
        right = null;
        left = null;
    }

    void fillDepth(LevelTreeNode root, int depth)
    {
        if(root==null){
            return;
        }
        root.depth= 0;

        fillDepth(root.left, depth+1);
        fillDepth(root.right, depth+1);
    }

    void fillVerticalLevel(LevelTreeNode root, int depth)
    {
        if(root==null){
            return;
        }
        root.depth= 0;

        fillVerticalLevel(root.left, depth-1);
        fillVerticalLevel(root.right, depth+1);
    }

}


public class LevelOrderTraversal {



    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        LevelTreeNode treeNode = null;

        String str[] = br.readLine().split(" ");

        for(int i=0 ; i<t; i++)
        {
            int data = Integer.parseInt(str[i]);
            treeNode = insert(treeNode, data);
        }


        treeNode.fillVerticalLevel(treeNode,0);

//        treeNode = fillVerticalLevel(treeNode,0);  // Commented as BS

        Map<Integer, Vector<LevelTreeNode>> vectorMap = new TreeMap<>();

        vectorMap = topViewLevelOrder(treeNode, 0, vectorMap);

        //print all first elements of the vectorMap
        for(Integer key: vectorMap.keySet()){
            bw.write(vectorMap.get(key).firstElement() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static LevelTreeNode insert(LevelTreeNode root, int data) {
        if(root == null) {
            return new LevelTreeNode(data);
        } else {
            LevelTreeNode cur;
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

    //save vertical levels in a vector map
    public static Map<Integer, Vector<LevelTreeNode>> topViewLevelOrder(LevelTreeNode root, int level, Map<Integer, Vector<LevelTreeNode>> vectorMap)
    {
        Vector<LevelTreeNode> vector = null;
        vector.addElement(root);

//        for()
        while(root.left!= null && root.right!=null)
        {
            vectorMap.put(level, vector);
        }



        return vectorMap;
    }



    // works but not fun
//    public static LevelTreeNode fillVerticalLevel(LevelTreeNode root, int level) {
//
//        if(root==null)
//        {
//            return null;
//        }
//        root.verticalLevel = level;
//        fillVerticalLevel(root.left, level-1);
//        fillVerticalLevel(root.right, level+1);
//        // store width-wise level order in mapHeight
//        return root;
//    }

    // Stright BS
//    public static void mapFillPreOrder(LevelTreeNode root) {
//        if(root==null)
//        {
//            return ;
//        }
//
//        if(vectorMap.containsKey(root.verticalLevel))
//        {
//            Vector vector= new Vector<LevelTreeNode>();
//            vector = vectorMap.get(root.verticalLevel);
//            vector.addElement(root);
//            vectorMap.remove(root.verticalLevel);
//            vectorMap.put(root.verticalLevel, vector);
//        }
//        else
//        {
//            Vector vector= new Vector<LevelTreeNode>();
//            vector.add(root);
//            vectorMap.put(root.verticalLevel, vector);
//        }
//
//        mapFillPreOrder(root.left);
//        mapFillPreOrder(root.right);
//        return;
//    }


    //      2 Queues approach
//        public static void levelOrder(TreeNode root) {
//
//        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
//        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
//        queue1.add(root);
//        boolean bool = true;
//
//
//        while(!queue1.isEmpty() || !queue2.isEmpty())
//        {
//            if(bool)
//            {
//                TreeNode current = queue1.peek();
//                queue1.remove();
//                System.out.print(current.data + " ");
//                if (current.left != null) {
//                    queue2.add(current.left);
//                }
//                if (current.right != null) {
//                    queue2.add(current.right);
//                }
//                if(queue1.isEmpty())
//                {
//                    bool = false;
//                    System.out.println();
//                }
//            }
//            else
//            {
//                TreeNode current = queue2.peek();
//                queue2.remove();
//                System.out.print(current.data + " ");
//                if (current.left != null) {
//                    queue1.add(current.left);
//                }
//                if (current.right != null) {
//                    queue1.add(current.right);
//                }
//                if(queue2.isEmpty())
//                {
//                    bool = true;
//                    System.out.println();
//                }
//            }
//
//        }
//    }


    //  simple traversal
//    public static void levelOrder(TreeNode root) {
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//
//        while(!queue.isEmpty())
//        {
//            TreeNode current = queue.peek();
//            queue.remove();
//            System.out.print(current.data+ " ");
//            if(current.left!=null)
//            {
//                queue.add(current.left);
//            }
//            if(current.right!=null)
//            {
//                queue.add(current.right);
//            }
//
//        }
//    }


}
