/**
 * CH11_FindTheSumOfMaximumSumSubarray Class
 *
 * <p>
 *
 * @note Given an array, find the sum of contiguous subarray with the largest sum. Given an unsorted
 *     array A, the maximum sum sub-array is the sub-array (contiguous elements) from A, for which
 *     the sum of the elements is maximum. In this challenge, we want to find the sum of the maximum
 *     sum sub-array. The array might have negative integers in any position, so we have to cater to
 *     those negative integers while choosing the contiguous subarray with the largest positive
 *     values.
 *     <p>
 * @note Kadane's Algorithm - The basic idea of Kadane’s algorithm is to scan the entire array and
 *     at each position find the maximum sum of the subarray ending there. This is achieved by
 *     keeping a currMax for the current array index and a globalMax.
 * @author David Kariuki
 * @since 17/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH11_FindTheSumOfMaximumSumSubarray {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr1 = {1, 7, -2, -5, 10, -1};

    System.out.println("Array: " + DataStructuresUtils.arrayToString(arr1));
    System.out.println("Sum: " + findMaxSumSubArray(arr1));
  }

  /**
   * Method to find the sum of maximum sum subarray
   *
   * <p>
   *
   * @note Runtime complexity - The runtime complexity of this solution is linear, O(n).
   *     <p>
   * @note Space complexity - The space complexity of this solution is constant, O(1).
   * @param arr - int[]
   */
  public static int findMaxSumSubArray(int[] arr) {

    if (arr.length < 1) {
      return 0;
    }

    int currMax = arr[0];
    int globalMax = arr[0];

    // Traverse array
    for (int i = 1; i < arr.length; i++) {

      // Check if current max is less than 0 to re-assign
      if (currMax < 0) {
        currMax = arr[i]; // Re-assign with current element at i
      } else {
        currMax += arr[i]; // Increment
      }

      // Check if global max is less that current max
      if (globalMax < currMax) {
        globalMax = currMax;
      }
    }
    return globalMax;
  }
}
