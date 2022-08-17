/**
 * Big (O) of Nested Loop With Addition
 * Compute the Big O complexity of the code snippet given below.
 *
 * @authr David Kariuki
 * @since 10/8/2022
 */

package AceTheJavaCodingInterview.module1_big_o_notation;

public class BigONestedLoopWithAddition {

    public static void main(String[] args) {
        int n = 10; // 1 step - Initializing a variable is a basic operation that costs one unit.
        int sum = 0; // 1 step - Initializing a variable is a basic operation that costs one unit.
        double pie = 3.14; // 1 step - Initializing a variable is a basic operation that costs one unit.

        /*
         * int var = 0; - Initializing a variable is a basic operation that costs one unit.
         *
         * var < n;
         * This condition executes in steps of 3,i.e., initially var = 0, and hence var is less than n.
         * In the next step var is  3 --> still less than n. Then var = 6 -> still less than n var = 9 --> still less
         * than n. But when var = 12, it is greater than n,loop breaks here.From this example notice that the loop
         * runs n/3 times and 1 time extra this condition is executed for breaking the loop.
         */
        for (int var = 0; var < n; var = var + 3) { // n/3 steps

            // The outer-loop runs n/3 times so the print statement is executed n/3 times.
            System.out.println("\nFor loop at " + var + " Pie: " + pie);

            /*
             * int j = 0 itself is executed in 1 unit of time.
             * However, this statement is executed n/3 times due to outer for-loop.
             *
             * j < n;
             * The outer loop runs n/3 times.The statement j < n executes in steps of 2 due to the inner loop.
             * In each iteration of the inner loop 2 is added to j. Therefore, this statement runs (n/2 + 1) times due
             * to inner loop,and in turn executes n/3(n/2 + 1) due to outer loop.
             */
            for (int j = 0; j < n; j = j + 2) {  // (n/3 * n/2) steps

                // (n/3 * n/2) steps - The outer loop runs n/3 times, and the inner loop runs n/2 times.Therefore,
                // sum++ is executed n/3(n/2) times.
                sum++;

                System.out.println("When var : " + var + " and j : " + j + " Sum : " + sum + " and n " + n);  //
                // (n/3 * n/2) steps
            }
        }
    }
}
