package com.assignment.eeighth;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

//class SinglyLinkedListNode {
//    public int data;
//    public SinglyLinkedListNode next;
//
//    public SinglyLinkedListNode(int nodeData) {
//        this.data = nodeData;
//        this.next = null;
//    }
//}
//
//class SinglyLinkedList {
//    public SinglyLinkedListNode head;
//    public SinglyLinkedListNode tail;
//
//    public SinglyLinkedList() {
//        this.head = null;
//        this.tail = null;
//    }
//
//    public void insertNode(int nodeData) {
//        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
//
//        if (this.head == null) {
//            this.head = node;
//        } else {
//            this.tail.next = node;
//        }
//
//        this.tail = node;
//    }
//}
//
//class SinglyLinkedListPrintHelper {
//    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
//        while (node != null) {
//            bufferedWriter.write(String.valueOf(node.data));
//
//            node = node.next;
//
//            if (node != null) {
//                bufferedWriter.write(sep);
//            }
//        }
//    }
//}

class ResultOne {

    /*
     * Complete the 'getNode' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER positionFromTail
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode revHead = reverse(llist);

        for(int i=0 ; i<positionFromTail ; i++)
        {
            revHead = revHead.next;
        }

        return revHead.data;
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode prev = null;

        if(llist == null || llist.next == null)
        {
            System.out.println(llist.data);
        }


        while(llist !=null)
        {
            SinglyLinkedListNode temp = llist.next;
            llist.next = prev;
            prev = llist;
            llist = temp;
        }
        return prev;

    }

}

public class GetNodeValue {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedList llist = new SinglyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int position = Integer.parseInt(bufferedReader.readLine().trim());

                int result = ResultOne.getNode(llist.head, position);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}































/**
 * package com.assignment.geighth;
 *
 * import java.util.Scanner;
 *
 * public class GetNodeValue {
 *
 *     public static void main(String args[]) throws Exception
 *     {
 *         Scanner sc = new Scanner(System.in);
 *
 *         int testcases = sc.nextInt();
 *
 *         while(testcases>0)
 *         {
 *
 *             int n = sc.nextInt();
 *
 *             System.out.println();
 *
 *             testcases--;
 *         }
 *
 *     }
 *
 * //    public static Queue<Integer> reverse(SinglyLinkedListNode llist) {
 * //        // Write your code here
 * //        Queue<Integer> prev = null;
 * //
 * //        if(llist == null || llist.next == null)
 * //        {
 * //            System.out.println(llist.data);
 * //        }
 * //
 * //
 * //        while(llist !=null)
 * //        {
 * //            SinglyLinkedListNode temp = llist.next;
 * //            llist.next = prev;
 * //            prev = llist;
 * //            llist = temp;
 * //        }
 * //        return prev;
 * //
 * //    }
 * }
 *
 *     class Node {
 *         public int data;
 *         public Node next;
 *
 *         public Node() {
 *         }
 *
 *         public Node(int data) {
 *             this.data = data;
 *         }
 *
 *         public Node(int data, Node next) {
 *             this.data = data;
 *             this.next = next;
 *         }
 *     }
 *
 *     class NodeList{
 *         public Node head;
 *         public Node tail;
 *
 *         public NodeList() {
 *             this.head = null;
 *             this.tail = null;
 *         }
 *
 *         public NodeList(Node head, Node tail) {
 *             this.head = head;
 *             this.tail = tail;
 *         }
 *
 *         public void insertNode(int nodeData) {
 *             Node node = new Node(nodeData);
 *
 *             if (this.head == null) {
 *                 this.head = node;
 *             } else {
 *                 this.tail.next = node;
 *             }
 *
 *             this.tail = node;
 *         }
 *
 *     }
 */