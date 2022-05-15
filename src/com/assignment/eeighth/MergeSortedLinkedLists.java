package com.assignment.eeighth;

/**
 * Given pointers to the heads of two sorted linked lists, merge them into a single, sorted linked list. Either head pointer may be null meaning that the corresponding list is empty.
 *
 * Example
 *  refers to
 *  refers to
 *
 * The new list is
 *
 * Function Description
 *
 * Complete the mergeLists function in the editor below.
 *
 * mergeLists has the following parameters:
 *
 * SinglyLinkedListNode pointer headA: a reference to the head of a list
 * SinglyLinkedListNode pointer headB: a reference to the head of a list
 * Returns
 *
 * SinglyLinkedListNode pointer: a reference to the head of the merged list
 * Input Format
 *
 * The first line contains an integer , the number of test cases.
 *
 * The format for each test case is as follows:
 *
 * The first line contains an integer , the length of the first linked list.
 * The next  lines contain an integer each, the elements of the linked list.
 * The next line contains an integer , the length of the second linked list.
 * The next  lines contain an integer each, the elements of the second linked list.
 *
 * Constraints
 *
 * , where  is the  element of the list.
 * Sample Input
 *
 * 1
 * 3
 * 1
 * 2
 * 3
 * 2
 * 3
 * 4
 * Sample Output
 *
 * 1 2 3 3 4
 * Explanation
 *
 * The first linked list is:
 * 1 2 3
 * The second linked list is:
 * 2 3
 * Hence, the merged linked list is:
 * 1 2 3 3 4
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MergeSortedLinkedLists {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();

        while(testcases>0)
        {
            Queue<Integer> queue1 = new LinkedList<Integer>();
            Queue<Integer> queue2 = new LinkedList<Integer>();


            int n = sc.nextInt();
            for(int i =0; i<n; i++)
            {
                queue1.add(sc.nextInt());
            }

            int m = sc.nextInt();

            for(int i =0; i<m; i++)
            {
                queue2.add(sc.nextInt());
            }

            Queue<Integer> queue = new LinkedList<Integer>();

            while(!queue1.isEmpty() && !queue2.isEmpty())
            {
                if(queue1.peek()>=queue2.peek())
                {
                    queue.add(queue2.remove());
                }
                else
                {
                    queue.add(queue1.remove());
                }
            }
            while(!queue1.isEmpty())
            {
                queue.add(queue1.remove());
            }

            while(!queue2.isEmpty())
            {
                queue.add(queue2.remove());
            }

            for(int i=0; i<m+n; i++)
            {
                System.out.print(queue.remove()+" ");
            }

            System.out.println();

            testcases--;
        }

    }



}
