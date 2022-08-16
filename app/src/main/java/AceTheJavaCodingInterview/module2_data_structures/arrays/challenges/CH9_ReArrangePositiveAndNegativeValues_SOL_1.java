/**
 * CH9_ReArrangePositiveAndNegativeValues_SOL_1 Class
 *
 * <p>
 *
 * @note
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH9_ReArrangePositiveAndNegativeValues_SOL_1 {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr = {10, -1, 20, 4, 5, -9, -6};

    System.out.println("Array before re-arranging : "
            + DataStructuresUtils.arrayToString(arr));

    arr = reArrange(arr);

    System.out.println("Array after re-arranging : "
            + DataStructuresUtils.arrayToString(arr));
  }

  static int[] reArrange(int[] arr) {

    int[] newArray = new int[arr.length];

    int j = 0;
    // Loop to get negatives
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {
        newArray[j++] = arr[i];
      }
    }

    // Loop to get positives
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        newArray[j++] = arr[i];
      }
    }

    return newArray;
  }
}
