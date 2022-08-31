/**
 * Problem set 1
 * @author David Kariuki
 * @since 14/8/2022
 */

package AceTheJavaCodingInterview.module1_big_o_notation.problem_sets;

@SuppressWarnings("unused")
public class ProblemSet1 {

    /**
     * Following is another implementation of insertion sort. If we feed an already sorted array to the following
     * snippet will the algorithm execute a linear number of instructions? Insertion sort’s best-case running time
     * is linear (think running a single loop) and not quadratic.
     */
    public void sort(int[] input) {

        for (int i = 1; i < input.length; i++) {
            int key = input[i];
            for (int j = i - 1; j >= 0; j--) {
                if (input[j] > key) {
                    int tmp = input[j];
                    input[j] = key;
                    input[j + 1] = tmp;
                }
            }
        }

        /*
         * Answer - No
         *
         * The algorithm represents insertion sort. However, the way the code is written, there’s no short-circuiting
         * for the nested loop when the values are already sorted so even in the best case, i.e. when the array is
         * sorted the inner loops run from the start of the array to the end. Unlike the implementation of insertion
         * sort in the lesson, the short-circuiting would never make the inner loop run when the input array is already
         * sorted. The best-case time would be linear and not quadratic. However, for the above snippet, the best case
         * would still be quadratic. The point to drive home is to exercise caution as slight implementation changes
         * can change complexities for the same algorithm.
         */
    }
}
