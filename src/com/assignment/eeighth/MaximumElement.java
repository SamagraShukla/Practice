package com.assignment.eeighth;
/**1 x  -Push the element x into the stack.
 2    -Delete the element present at the top of the stack.
 3    -Print the maximum element in the stack.
 Function Description

 Complete the getMax function in the editor below.

 getMax has the following parameters:
 - string operations[n]: operations as strings

 Returns
 - int[]: the answers to each type 3 query

 Input Format

 The first line of input contains an integer, . The next  lines each contain an above mentioned query.

 Constraints

 Constraints



 All queries are valid.

 Sample Input

 STDIN   Function
 -----   --------
 10      operations[] size n = 10
 1 97    operations = ['1 97', '2', '1 20', ....]
 2
 1 20
 2
 1 26
 1 20
 2
 3
 1 91
 3
 Sample Output

 26
 91
*/


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MaximumElement {


    static class Result {

        /*
         * Complete the 'getMax' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts STRING_ARRAY operations as parameter.
         */

        public static List<Integer> getMax(List<String> operations) {
            // Write your code here
            List<Integer> list = new ArrayList<Integer>();
            ListIterator<String> listIterator = operations.listIterator();
            Stack<Integer> stack = new Stack<Integer>();
            Stack<Integer> stackMax = new Stack<Integer>();

            while(listIterator.hasNext())
            {
                String str[] = listIterator.next().split(" ");
                if(str[0].equals("1"))
                {
                    int n = Integer.parseInt(str[1]);
                    stack.push(n);
                    if(stackMax.isEmpty()||stackMax.peek()<=n){
                        stackMax.push(n);
                    }
                }
                if(str[0].equals("2"))
                {
                    if(stack.pop().equals(stackMax.peek())) {
                        stackMax.pop();
                    }

                }
                if(str[0].equals("3"))
                {
                    list.add(stackMax.peek());
                }

            }

            return list;

        }

    }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> ops = IntStream.range(0, n).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .collect(toList());

            List<Integer> res = Result.getMax(ops);

            bufferedWriter.write(
                    res.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }


}
