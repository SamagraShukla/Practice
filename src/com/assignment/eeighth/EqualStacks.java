package com.assignment.eeighth;

/**You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

 Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they are all the same height, then return the height.

 Example




 There are  and  cylinders in the three stacks, with their heights in the three arrays. Remove the top 2 cylinders from  (heights = [1, 2]) and from  (heights = [1, 1]) so that the three stacks all are 2 units tall. Return  as the answer.

 Note: An empty stack is still a stack.

 Function Description

 Complete the equalStacks function in the editor below.

 equalStacks has the following parameters:

 int h1[n1]: the first array of heights
 int h2[n2]: the second array of heights
 int h3[n3]: the third array of heights
 Returns

 int: the height of the stacks when they are equalized
 Input Format

 The first line contains three space-separated integers, , , and , the numbers of cylinders in stacks , , and . The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:

 The second line contains  space-separated integers, the cylinder heights in stack . The first element is the top cylinder of the stack.
 The third line contains  space-separated integers, the cylinder heights in stack . The first element is the top cylinder of the stack.
 The fourth line contains  space-separated integers, the cylinder heights in stack . The first element is the top cylinder of the stack.
 Constraints

 Sample Input

 STDIN       Function
 -----       --------
 5 3 4       h1[] size n1 = 5, h2[] size n2 = 3, h3[] size n3 = 4
 3 2 1 1 1   h1 = [3, 2, 1, 1, 1]
 4 3 2       h2 = [4, 3, 2]
 1 1 4 1     h3 = [1, 1, 4, 1]
 Sample Output

 5

 */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class EqualStacks {

    static class Result {

        /*
         * Complete the 'equalStacks' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY h1
         *  2. INTEGER_ARRAY h2
         *  3. INTEGER_ARRAY h3
         */

        public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
            // Write your code here

            Stack<Integer> stack1 = new Stack<Integer>();
            Stack<Integer> stack2 = new Stack<Integer>();
            Stack<Integer> stack3 = new Stack<Integer>();

            int val1=0, val2=0, val3=0;
            for(int i=h1.size()-1; i>=0; i--)
            {
                stack1.push(h1.get(i));
                val1 = val1 +h1.get(i);
            }
            for(int i=h2.size()-1; i>=0; i--)
            {
                stack2.push(h2.get(i));
                val2 = val2 +h2.get(i);
            }
            for(int i=h3.size()-1; i>=0; i--)
            {

                stack3.push(h3.get(i));
                val3 = val3 +h3.get(i);
            }

            while(val1!=val2 || val2!=val3)
            {
//  this logic sucks 26/31 times
//                int max = Math.max(Math.max(val1,val2),Math.max(val1,val2));
//                if(max==val1)
//                {
//                    val1 = val1-stack1.pop();
//                }else if(max==val2)
//                {
//                    val2 = val2-stack2.pop();
//                }else if(max==val3)
//                {
//                    val3 = val3-stack3.pop();
//                }

                // 27 test cases failed out of 31
                if(val1>=val2 && val1>=val3)
                {
                    val1-= stack1.pop();
                }
                else if(val2>=val1 && val2>=val3)
                {
                    val2-= stack2.pop();
                }
                else
                {
                    val3-= stack3.pop();
                }

            }


            return val1;

        }

    }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n1 = Integer.parseInt(firstMultipleInput[0]);

            int n2 = Integer.parseInt(firstMultipleInput[1]);

            int n3 = Integer.parseInt(firstMultipleInput[2]);

            List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Result.equalStacks(h1, h2, h3);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }


}

/**
 * working code below, match when you get the time to document properly
 */

//
//
//import java.io.*;
//        import java.math.*;
//        import java.security.*;
//        import java.text.*;
//        import java.util.*;
//        import java.util.concurrent.*;
//        import java.util.function.*;
//        import java.util.regex.*;
//        import java.util.stream.*;
//        import static java.util.stream.Collectors.joining;
//        import static java.util.stream.Collectors.toList;
//
//class Result {
//
//    /*
//     * Complete the 'equalStacks' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts following parameters:
//     *  1. INTEGER_ARRAY h1
//     *  2. INTEGER_ARRAY h2
//     *  3. INTEGER_ARRAY h3
//     */
//
//    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
//        // Write your code here
//
//        // Write your code here
//
//        Stack<Integer> stack1 = new Stack<Integer>();
//        Stack<Integer> stack2 = new Stack<Integer>();
//        Stack<Integer> stack3 = new Stack<Integer>();
//
//        int val1=0, val2=0, val3=0;
//        for(int i=h1.size()-1; i>=0; i--)
//        {
//            stack1.push(h1.get(i));
//            val1 = val1 +h1.get(i);
//        }
//        for(int i=h2.size()-1; i>=0; i--)
//        {
//            stack2.push(h2.get(i));
//            val2 = val2 +h2.get(i);
//        }
//        for(int i=h3.size()-1; i>=0; i--)
//        {
//
//            stack3.push(h3.get(i));
//            val3 = val3 +h3.get(i);
//        }
//
//        while(val1!=val2 || val2!=val3)
//        {
//            if(val1>=val2 && val1>=val3)
//            {
//                val1-= stack1.pop();
//            }
//            else if(val2>=val1 && val2>=val3)
//            {
//                val2-= stack2.pop();
//            }
//            else
//            {
//                val3-= stack3.pop();
//            }
//        }
//
//
//        return val1;
//
//
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n1 = Integer.parseInt(firstMultipleInput[0]);
//
//        int n2 = Integer.parseInt(firstMultipleInput[1]);
//
//        int n3 = Integer.parseInt(firstMultipleInput[2]);
//
//        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.equalStacks(h1, h2, h3);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
