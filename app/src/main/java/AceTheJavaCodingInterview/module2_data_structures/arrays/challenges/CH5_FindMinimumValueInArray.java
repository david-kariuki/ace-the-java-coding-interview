/**
 * CH5_FindMinimumValueInArray Class
 *
 * <p>
 *
 * @note Given an array of size "n", can you find the minimum value in the array?
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH5_FindMinimumValueInArray {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr = new int[] {30, 43, 55, 32, 12, 23, 4, 21, 21, 55, 67, 90, 32, 21};

    System.out.println(
        "Minimum in array : "
            + DataStructuresUtils.arrayToString(arr)
            + " "
            + "is : "
            + findMinimum(arr));
  }

  /**
   * Method to find minimum
   *
   * <p>
   *
   * @note Time Complexity - Since the entire list is iterated over once, this algorithm is in
   *     linear time - O(n)
   * @param arr - int[]
   */
  public static int findMinimum(int[] arr) {

    int minimum = arr[0];

    // At every Index compare its value with minimum and if it is less, then
    // make that index value new minimum value
    for (int i = 0; i < arr.length; i++) {
      // Check if element at current index is smaller than set minimum
      if (arr[i] < minimum) {
        minimum = arr[i]; //  Assign new minimum
      }
    }

    return minimum;
  }
}
