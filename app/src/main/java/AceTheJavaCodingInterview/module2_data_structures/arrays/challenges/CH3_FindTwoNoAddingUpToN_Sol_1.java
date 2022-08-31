/**
 * CH3_FindTwoNoAddingUpToN_Sol_1 Class
 *
 * <p>
 *
 * @note Challenge 2: Merge Two Sorted Arrays
 * Given an array and a number "n", find two numbers from the array that
 * sums up to "n".
 * @author David Kariuki
 * @since 14/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

public class CH3_FindTwoNoAddingUpToN_Sol_1 {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int n = 9;
    int[] arr1 = {2, 4, 5, 7, 8};

    int[] arr2 = findSum(arr1, n);
    int num1 = arr2[0];
    int num2 = arr2[1];

    if ((num1 + num2) != n) System.out.println("Not Found");
    else {
      System.out.println("Number 1 = " + num1);
      System.out.println("Number 2 = " + num2);
      System.out.println("Sum = " + (n));
    }
  }

  /**
   * Method to find the sum of two index elements adding up to n and the elements
   *
   * @param arr - int[]
   * @param n - Target sum
   */
  public static int[] findSum(int[] arr, int n) {

    int[] result = new int[2]; // to store the pair of values.

    for (int i = 0; i < arr.length; i++) { // traverse arr
      for (int j = i + 1; j < arr.length; j++) { // traverse arr again
        if (arr[i] + arr[j] == n) { // find where sum is equal to n
          result[0] = arr[i];
          result[1] = arr[j];
          return result; // return the pair of numbers
        }
      }
    }
    return arr;
  }
}
