/**
 * Problem set 2
 * @author David Kariuki
 * @since 14/8/2022
 */

package AceTheJavaCodingInterview.module1_big_o_notation.problem_sets;


/**
 * <p>
 * @note Question 1
 * Suppose your friend discovers a new algorithm and in his excitement tells you that his algorithm has a lower
 * bound of O(n2). Can you explain why your friend's statement makes no sense?
 *
 * <p>
 * Answer
 * Big O notation denotes an upper bound but is silent about the lower bound. Treat it like a cap on the worst
 * that can happen. So when someone says that an algorithm has a lower bound of O(n2) that translates into saying
 * the lower bound can at worst be quadratic in complexity. By definition, the lower bound is the best an algorithm
 * can perform. Combine the two statements and your friend is saying the algorithm he found in the best case can
 * perform in quadratic time or better. It can also perform in linear time or constant time, we just don't know.
 * So your friend is effectively not telling you anything about the lower bound on the performance of his new-found
 * algorithm.
 *
 * <p>
 * @note Question 2
 * Does O^(22n) equal O^(2n) ?
 *
 * <p>
 * @note Question 3
 * Give an example of an algorithm whose best case is equal to its worst case?
 * Counting Sort and Radix Sort are two algorithms which have the same best, worst and average case complexities.
 *
 * <p>
 * @question Question 4 - Time complexity - Work out the time complexity for the avarager method below
 * @see #averager(int[])
 *
 * <p>
 * @question Question 5 - What is the complexity of the below snippet
 * @see #question5(int[])
 *
 * <p>
 * @question Question 6 - Consider the following snippet of code and determine its running time complexity -
 * @see #question6(int[])
 *
 * <p>
 * @question Question 7 - Determine the time complexity for the following snippet of code
 * @see #question7(int, int)
 *
 * <p>
 * @question Question 8 - Determine the time complexity for the following snippet of code
 * @see #question8(int)
 *
 * <p>
 * @question Question 9 - Determine the time complexity for the following snippet of code
 * @see #question9(int, int)
 */

@SuppressWarnings({"unused", "StatementWithEmptyBody"})
public class ProblemSet2 {

    /**
     * Question 4
     * @param A - int[]
     */
    void averager(int[] A) {

        float avg = 0.0f;
        int j, count;

        for (j = 0; j < A.length; j++) {
            avg += A[j];
        }

        avg = avg / A.length;
        count = j = 0;

        do {

            while (j < A.length && A[j] != avg) {
                j++;
            }

            if (j < A.length) {
                A[j++] = 0;
                count++;
            }
        } while (j < A.length);
    }

    /**
     * Question 5
     */
    public void question5(int[] array) {

        for( int i=0; i<array.length; i++){

            for (int j=0; j<10000; j++) {
            }
        }
    }

    /**
     * Question 6
     * @param array - int[]
     */
    void question6(int[] array) {

        int n = array.length;
        double runFor = (Math.pow(-1, n) * Math.pow(n, 2));

        for (int i = 0; i < runFor; i++) {

            System.out.println("Find how complex I am ?");
        }

        // To the untrained eye, it may appear that since there's a single loop, the runtime complexity would likely
        // be O(n), which is incorrect. If you look at the snippet again: the worst case happens for even sizes of the
        // input array. The loop doesn’t run when the size of the array is an odd number. Next, the loop runs a
        // quadratic number of times the length of the array when the length is even. Ask yourself, does a bigger
        // array result in the loop running for a longer period of time? Yes, it does. The bigger the array size and
        // provided it is an even number, the single loop runs as if it were a nesting of two loops.

        // Therefore, the complexity of this snippet of code is O(n2);
    }

    /**
     * Question 7
     * @param n - int
     * @param m - int
     */
    void question7(int n, int m) {

        for (int j = 0; j < n; j++) {

            for (int i = 0; i < m % n; i++) {

                System.out.println("Hello");
            }
        }

        // Let's start with the case when n equals m. In that case, m%n will equal 0 and the inner loop will not run.
        // So complexity will be O(n). If n > m then m%n will equal m, so now the inner loop will run for m times,
        // giving us a total complexity of O(m*n). The last case is when n < m then m%n will equal values ranging from
        // 1 to n-1. So the inner loop in the worst case would run for n-1 times. The complexity in the last case would
        // then be O(n*(n-1)) which is O(n2).

        // Note that O(m*n) is a tighter bound for the second case, but since we are talking in big O terms, we can
        // say for the second case, when n > m, then O(m*n) < O(n2) so for the second case, we can say the complexity
        // will be O(n2). So in the worst case, the complexity would be O(n2).
    }

    /**
     * Question 8
     * @param n - int
     */
    public void question8(int n) {

        /* Commenting due to duplicate int i declaration
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 3; i++) {
                for (int i = 0; i < n; i++) {
                    System.out.println("I have 3 loops");
                }
            }
        }
        */

        // It may seem that the complexity of the snippet is cubic since we have 3 loops. But the second loop runs
        // for a constant number of times. One way to think about the above snippet is to unroll the second loop.
        // We can say the above code is equivalent to the following. The output of both the snippets would be the same.
        // From the unrolling, it is evident that the three inner loops contribute n + n + n = 3n = O(n) and the
        // out most loop runs for n too therefore the overall complexity is O(n2).
    }

    /**
     * Question 8
     * @param n - int
     * @param m - int
     */
    public void question9(int n, int m) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                System.out.println("I have 2 loops");
            }
        }

        // The above snippet is a traditional example of nested loops. Whenever you get nested loops, each running for
        // a variable number of times, the complexity of the entire snippet is the product of the variables
        // controlling the repetition of each loop. The string message would be printed for a total of (m * n)
        // times and thus the overall, complexity will be O(mn)
    }
}
