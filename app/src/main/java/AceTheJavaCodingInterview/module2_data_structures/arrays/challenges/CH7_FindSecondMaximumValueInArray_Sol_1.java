/**
 * CH7_FindSecondMaximumValueInArray_Sol_1 Class
 *
 * <p>
 *
 * @note Given an array of size n, can you find the second maximum element in the array?
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH7_FindSecondMaximumValueInArray_Sol_1 {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr = {-2, -33, -10, -456};

    System.out.println("Array: " + DataStructuresUtils.arrayToString(arr));

    int secMax = findSecondMaximum(arr);

    System.out.println("Second maximum: " + secMax);
  }

  /**
   * Method to find second maximum number in an int[] arr
   *
   * <p>
   *
   * @note We traverse the array twice. In the first traversal, we find the maximum element. In the
   *     second traversal, find the greatest element less than the element obtained in the first
   *     traversal.
   *     <p>
   * @note Time Complexity - The time complexity of the solution is in O(n)
   * since the array is traversed twice but in separate loops. Which means
   * O(n+ n) => O(n)
   * @param arr - int[] arr
   */
  public static int findSecondMaximum(int[] arr) {

    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    // Find the maximum value in the array by comparing each index with max
    // If an element is greater than max then update max to be equal to it
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    // Find the second maximum value by comparing each index with secondmax
    // If an element is greater than secondmax and not equal to previously
    // calculated max, then update secondmax to be equal to that element.
    for (int i = 0; i < arr.length; i++) {
      if ((arr[i] > secondMax) && (arr[i] < max)) {
        secondMax = arr[i];
      }
    }

    return secondMax;
  }
}
