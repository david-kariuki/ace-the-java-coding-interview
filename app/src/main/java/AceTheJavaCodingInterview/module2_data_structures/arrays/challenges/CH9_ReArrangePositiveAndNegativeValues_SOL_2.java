/**
 * CH9_ReArrangePositiveAndNegativeValues_SOL_2 Class
 *
 * <p>
 *
 * @note
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH9_ReArrangePositiveAndNegativeValues_SOL_2 {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr = {-50, -1, 20, 4, 5, -9, -6};

    System.out.println("Array before re-arranging : "
            + DataStructuresUtils.arrayToString(arr));

    reArrange(arr);

    System.out.println("Array after re-arranging : "
            + DataStructuresUtils.arrayToString(arr));
  }

  static void reArrange(int[] arr) {

    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 0) {   // if negative number found
        if (i != j) {
          int temp = arr[i];
          arr[i] = arr[j]; // Swapping with leftmost positive
          arr[j] = temp;
        }
        j++;
      }
    }
  }
}
