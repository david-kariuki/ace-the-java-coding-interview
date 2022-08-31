/**
 * Big (O) of Nested Loop With Multiplication
 * Compute the Big O complexity of the code snippet given below.
 *
 * @authr David Kariuki
 * @since 12/8/2022
 */

package AceTheJavaCodingInterview.module1_big_o_notation;

@SuppressWarnings("ALL")
public class BigONestedLoopWithMultiplication {

	public static void main(String[] args) {
		withMultiplicationBasic1();
		withMultiplicationBasic2();
		withMultiplicationIntermediate();
		withMultiplicationAdvanced();
	}

	/**
	 * @note Nested Loop with Multiplication (Basic) 1
	 * Compute the Big O complexity of the code snippet given below.
	 */
	public static void withMultiplicationBasic1() {

		System.out.println("\n\n Starting Simple");

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

	/**
	 * @note Nested Loop with Multiplication (Basic) 2
	 * Compute the Big O complexity of the code snippet given below.
	 */
	public static void withMultiplicationBasic2() {

		System.out.println("\n\n Starting Basic");

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

		// Answer -> O(nlog2(n))
	}

	/**
	 * @note Nested Loop with Multiplication (Intermediate)
	 * Compute the Big O complexity of the code snippet given below.
	 */
	public static void withMultiplicationIntermediate() {

		System.out.println("\n\n Starting Intermediate 1");

		int n = 10;    //O(1)
		int sum = 0;  //O(1)
		int j = 1;   //O(1)
		double pie = 3.14;  //O(1)

		//O(?)
		for (
				int var = 1; // O(1)
				var < n;  // n/3 + 1
				var += 3 // n/3
		) {

			System.out.println("Pie: " + pie); // n/3
			j = 1; // n/3
			while (j < n) { //O(?)
				sum += 1; // (log_3(n) + 1 ) * n/3
				j *= 3; // log_3(n) * n/3
			}
		}

		System.out.println("Sum: " + sum); //O(1)

		// Answer -> O(nlog(n))
	}

	/**
	 * @note Nested Loop with Multiplication (Advanced)
	 * Compute the Big O complexity of the code snippet given below.
	 */
	public static void withMultiplicationAdvanced() {
		int n = 10; //O(1)
		int sum = 0; //O(1)
		double pie = 3.14; //O(1)

		for (int var = 0; var < n; var++) {    //O(n)
			int j = 1;  //O(n)
			System.out.println("Pie: " + pie); //O(n)
			while(j < var) { // O((n) * (log2 var))
				sum += 1; // O((n) * (log2 var))
				j *= 2;  // O((n) * (log2 var))
			}
		}

		System.out.println("Sum: " + sum); //O(1)

		// Answer -> O(nlog2(n))
	}

	/**
	 * @note Nested Loop with Multiplication (Pro)
	 * Compute the Big O complexity of the code snippet given below.
	 */
	public static void withMultiplicationPro() {

		int n = 10;   // O(1)
		int sum = 0;  // O(1)
		int j = 1;    // O(1)
		double pie = 3.14; // O(1)

		for (int var = 0; var < n; var++) {  // 0(n)

			System.out.println("Pie: " + pie); // 0(n)
			while(j < var) { // 0(n)
				sum += 1;  // 0(n)
				j *= 2;  // 0(n)
			}
		}

		System.out.println("Sum: " + sum); // O(1)

		// Answer O(n)
	}
}