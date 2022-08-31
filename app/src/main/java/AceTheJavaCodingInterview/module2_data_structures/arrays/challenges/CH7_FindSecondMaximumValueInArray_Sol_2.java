/**
 * CH7_FindSecondMaximumValueInArray_Sol_2 Class
 *
 * <p>
 *
 * @note Given an array of size n, can you find the second maximum element in the array?
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH7_FindSecondMaximumValueInArray_Sol_2 {

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
   * @note Time Complexity - This solution is in O(n) since the list is traversed once only.
   * @param arr - int[] arr
   */
  public static int findSecondMaximum(int[] arr) {

    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    // Keep track of Maximum value, whenever the value at an array index is greater
    // than current Maximum value then make that max value 2nd max value and
    // make that index value maximum value
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        secondMax = max;
        max = arr[i];
      } else if (arr[i] > secondMax && arr[i] != max) {
        secondMax = arr[i];
      }
    }

    return secondMax;
  }
}
