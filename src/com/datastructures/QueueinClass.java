package com.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class QueueinClass {
    public static void main(String args[])
    {
        Queue<Integer> q = new LinkedList<Integer>();
        // Adds elements {0, 1, 2, 3, 4} to
        // the queue
        for (int i = 0; i < 5; i++)
            q.add(i);

        // Display contents of the queue.
        System.out.println("Elements of queue "
                + q);

        // To remove the head of queue.
        int removedele = q.remove();
        System.out.println("removed element-"
                + removedele);

        System.out.println(q);

        // To view the head of queue
        int head = q.peek();
        System.out.println("head of queue-"
                + head);


        // Rest all methods of collection
        // interface like size and contains
        // can be used with this
        // implementation.
        int size = q.size();
        System.out.println("Size of queue-"
                + size);



        System.out.println("poll "+q.poll());
        System.out.println(q.add(11));
        System.out.println("top"+q.peek());
        System.out.println(q.add(12));
        System.out.println(q.add(13));
        System.out.println(q.add(14));
        System.out.println("top"+q.peek());
        System.out.println("removed"+q.remove());
        System.out.println("top"+q.peek());
        System.out.println("removed"+q.remove());
        System.out.println("top"+q.peek());
        System.out.println("removed"+q.remove());
        System.out.println("top"+q.peek());
        System.out.println("removed"+q.remove());
        System.out.println("top"+q.peek());
        System.out.println("removed"+q.remove());
        System.out.println("top"+q.peek());

    }
}
