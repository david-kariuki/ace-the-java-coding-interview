/**
 * SquaringASortedArray Class
 *
 * <p>
 *
 * @question Problem Statement - Given a sorted array, create a new array containing squares of all
 *     the numbers of the input array in the sorted order.
 *     <p>
 * @note Solution - use two-pointers starting at both ends of the input array. At any step,
 *     whichever pointer gives us the bigger square, we add it to the result array and move to the
 *     next/previous number according to the pointer.
 *     <p>
 * @note Time complexity - The above algorithm’s time complexity will be O(N) O(N) as we are
 *     iterating the input array only once.
 *     <p>
 * @note Space complexity - The above algorithm’s space complexity will also be O(N) O(N) ; this
 *     space will be used for the output array.
 * @author David Kariuki
 * @since 23/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

public class SquaringASortedArray {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {
    int[] result = SquaringASortedArray.makeSquares(new int[] {-2, -1, 0, 2, 3});
    for (int num : result) System.out.print(num + " ");
    System.out.println();

    result = SquaringASortedArray.makeSquares(new int[] {-3, -1, 0, 1, 2});
    for (int num : result) System.out.print(num + " ");
    System.out.println();
  }

  /**
   * Method to make squares
   *
   * @param arr - int[]
   * @return int[]
   */
  public static int[] makeSquares(int[] arr) {

    int n = arr.length;
    int[] squares = new int[n];

    int highestSquareIdx = n - 1;

    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {

      int leftSquare = arr[left] * arr[left];
      int rightSquare = arr[right] * arr[right];

      if (leftSquare > rightSquare) {
        squares[highestSquareIdx--] = leftSquare;
        left++;
      } else {
        squares[highestSquareIdx--] = rightSquare;
        right--;
      }
    }

    return squares;
  }
}
