/**
 * CH10_RearrangeSortedArrayInMaxOrMinForm_SOL_2 Class
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

public class CH10_RearrangeSortedArrayInMaxOrMinForm_SOL_2 {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.print("Array before min/max: ");
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
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
   * @note Time Complexity - The time complexity of this solution is in O(n). The space complexity
   *     is constant.
   * @param arr - int[]
   */
  static void maxMin(int[] arr) {

    int maxIdx = arr.length - 1;
    int minIdx = 0;

    // Store any element that is greater than the maximum element in the array
    int maxElem = arr[maxIdx] + 1;

    // Traverse array
    for (int i = 0; i < arr.length; i++) {

      // at even indices we will store maximum elements
      if (i % 2 == 0) {

        arr[i] += (arr[maxIdx] % maxElem) * maxElem;
        maxIdx -= 1;

      } else { // at odd indices we will store minimum elements

        arr[i] += (arr[minIdx] % maxElem) * maxElem;
        minIdx += 1;
      }
    }
    // dividing with maxElem to get original values.
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] / maxElem;
    }
  }
}
