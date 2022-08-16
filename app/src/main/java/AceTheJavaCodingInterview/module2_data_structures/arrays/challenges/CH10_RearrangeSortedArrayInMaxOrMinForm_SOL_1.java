/**
 * CH10_RearrangeSortedArrayInMaxOrMinForm_SOL_1 Class
 *
 * <p>
 *
 * @note Given an array, can you re-arrange the elements such that the first position will have the
 *     largest number, the second will have the smallest, the third will have the second-largest,
 *     and so on.
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH10_RearrangeSortedArrayInMaxOrMinForm_SOL_1 {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    System.out.print("Array before min/max: ");

    System.out.print(DataStructuresUtils.arrayToString(arr));
    System.out.println();

    maxMin(arr);

    System.out.print("Array after min/max: ");
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    System.out.println();
  }

  /**
   * Method to find max/min
   *
   * <p>
   *
   * @note Time Complexity -  The time complexity of this problem is O(n)
   * as the array is iterated over once.
   * @param arr - int[]
   */
  @SuppressWarnings("ManualArrayCopy")
  static void maxMin(int[] arr) {

    // Create a result array to hold re-arranged version of given arr
    int[] result = new int[arr.length];

    int pointerSmall = 0; // PointerSmall => Start of arr
    int pointerLarge = arr.length - 1; // PointerLarge => End of arr

    // Flag which will help in switching between two pointers
    boolean switchPointer = true;

    for (int i = 0; i < arr.length; i++) {

      if (switchPointer) {
        result[i] = arr[pointerLarge--]; // Copy large values
      } else {
        result[i] = arr[pointerSmall++]; // Copy small values
      }

      switchPointer = !switchPointer; // Switching between small and large
    }

    // Copy new array into old array
    for (int j = 0; j < arr.length; j++) {
      arr[j] = result[j]; // Copying to original array
    }
  }
}
