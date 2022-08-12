/**
 * Big (O) of Nested Loop With Multiplication
 * Compute the Big O complexity of the code snippet given below.
 *
 * @authr David Kariuki
 * @since 12/8/2022
 */

package AceTheJavaCodingInterview.big_o_notation;

public class BigONestedLoopWithMultiplication {

	public static void main(String[] args) {

		example1();
		withMultiplicationBasic();
	}

	private static void example1() {

		System.out.println("\n\n Starting example 1 ");

		int n = 16; // O(time complexity of the called function)
		int sum = 0; // O(1)
		double pie = 3.14; // O(1)
		int var = 1; // O(1


		while (var < n) {  // O(log n)

			System.out.println("Pie: " + pie); // O(log n)

			for (int j = 0;  // O(log n)
				 j < var; j++) {  // 2n
				sum++;  //  (2n-1)
			}
			var *= 2; // O(log n)
		} //end of while loop

		System.out.println("Sum: " + sum); //O(1)

		// Answer -> O(n)
	}

	private static void withMultiplicationBasic() {

		System.out.println("\n\n Starting example 2");

		int n = 10; // O(time complexity of the called function)
		int sum = 0; //O(1)
		double pie = 3.14; //O(1)
		int var = 1;


		while (var < n) { // O(log3 n)
			System.out.println("Pie: " + pie); // O(log3 n)

			for (int j = 1; // O(log3 n)
				// The inner loop is executed n/2 times. This condition is however, checked 1 more time for breaking
				// the loop.The outer loop is executed log3(n) times. Therefore, this statement is executed
				// log3(n) x (n/2 + 1) times
				 j < n;

				// The inner loop is executed n/2 times. The outer loop is executed log3(n) times. Therefore, this
				// statement is executed log3(n) x (n/2) times
				 j = j + 2) {  // O((log3 n)* (n/2))

				sum++;  // O((log3 n)* (n/2) * 2)
			}
			var *= 3;  // O(log3 n)
		} //end of while loop
		System.out.println("Sum: " + sum); //O(1)

		// Answer -> nlog2(n)
	}

	private static void withMultiplicationIntermediate() {

			int n = 10;
			int sum = 0;
			int j = 1;
			double pie = 3.14;

			for (int var = 1; var < n; var += 3) {   // O(n/3)
				System.out.println("Pie: " + pie);    // O(n/3)
				j = 1;  // O(n/3)
				while (j < n) { // O((n/3) * (log3 n))
					sum += 1;      // O((n/3) * (log3 n))
					j *= 3;        // O((n/3) * (log3 n))
				}
			}
			System.out.println("Sum: " + sum); //O(1)

	}
}
