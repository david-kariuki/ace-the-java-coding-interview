/**
 * Big (O) of Nested Loop With Subtraction
 * Compute the Big O complexity of the code snippet given below.
 *
 * @authr David Kariuki
 * @since 11/8/2022
 */

package AceTheJavaCodingInterview.module1_big_o_notation;

public class BigONestedLoopWithSubtraction {

    public static void main(String[] args) {
        int n = 10; // O(time complexity of the called function)
        int sum = 0; //O(1)
        double pie = 3.14; //O(1)

        for (int var = n; var >= 1; var = var - 3) { // O(n/3)
            System.out.println("Pie: " + pie); // O(n/3)

            /*
            * j >= 0 is executed n + 2 times due to the inner loop. For example if n = 10.
            * Then j can have values10, 9, 8, ..., 2, 1, 0. This means that j >= 0 will execute n + 1times
            * successfully and another +1 for the loop breaking condition. Total n + 2However, due to the outer loop
            * this statement is executed a further n/3 times.Therefore, running time of this statement is n/3(n + 2).
            * */
            for (int j = n; j >= 0; j = j - 1) { // O((n/3)*(n+1))
                sum++; // O((n/3)*(n+1))
            }
        } //end of outer for loop
        System.out.println("Sum: " + sum);//O(1)
    } //end of main
}
