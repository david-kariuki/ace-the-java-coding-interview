/**
 * CH2_MergeTwoSortedArrays Class
 *
 * <p>
 *
 * @note Challenge 2: Merge Two Sorted Arrays
 * @author David Kariuki
 * @since 14/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import java.util.Arrays;

public class CH2_FindTwoNoAddingUpToN {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int n = 27;
    int[] arr = new int[] {1, 21, 3, 14, 5, 60, 7, 6};

    System.out.println("\n" + Arrays.toString(findSum(arr, n)));
  }

  private static int[] findSum(int[] arr, int n) {

    int[] result = new int[2];

    int i = 0, length = arr.length, k = 0;

    while (i < length) {

      System.out.println("i : " + i);

      for (int j = 0; j < length; j++) {

        System.out.println("j : " + i);

        if (j != i) {
          if ((arr[j] + arr[i]) == n) {

            result[k++] = arr[i];
            result[k++] = arr[j + 1];
          }
        }

        i++;
      }
    }

    return result;
  }
}
