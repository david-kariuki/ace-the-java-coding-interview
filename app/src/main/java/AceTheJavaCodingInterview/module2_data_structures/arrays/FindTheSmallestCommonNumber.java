/**
 * FindTheSmallestCommonNumber Class
 *
 * <p>
 *
 * @question Given three integer arrays sorted in ascending order, return the smallest number found
 *     in all three arrays.
 * @author David Kariuki
 * @since 18/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class FindTheSmallestCommonNumber {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] v1 = new int[] {6, 7, 10, 25, 30, 63, 64};
    int[] v2 = new int[] {0, 4, 5, 6, 7, 8, 50};
    int[] v3 = new int[] {1, 6, 10, 14};
    System.out.println("Array 1: " + DataStructuresUtils.arrayToString(v1));
    System.out.println("Array 2: " + DataStructuresUtils.arrayToString(v2));
    System.out.println("Array 3: " + DataStructuresUtils.arrayToString(v3));

    Integer result = findLeastCommonNumber(v1, v2, v3);
    System.out.println("Least Common Number: " + result);
  }

  /**
   * Method to find the least common number
   *
   * <p>
   *
   * @note Time complexity - The time complexity of the solution is linear, O (n).
   * @note Space complexity - The space complexity of the solution is constant, O(1) .
   * @param arr1 - int[]
   * @param arr2 - int[]
   * @param arr3 - int[]
   * @return Integer
   */
  static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {

    // Initialize starting indexes for arr1, arr2 and arr3
    int i = 0, j = 0, k = 0;

    while (i < arr1.length && j < arr2.length && k < arr3.length) {

      // Finding the smallest common number
      if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        return arr1[i];
      }

      // Increment iterator for the smallest value
      if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
        i++;
      } else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
        j++;
      } else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
        k++;
      }
    }

    return -1;
  }
}
