/**
 * BitonicArrayMaximum Class
 *
 * <p>
 *
 * @question Problem Statement - Find the maximum value in a given Bitonic array. An array is
 *     considered bitonic if it is monotonically increasing and then monotonically decreasing.
 *     Monotonically increasing or decreasing means that for any index i in the array arr[i] !=
 *     arr[i+1].
 * @note Example
 *     <p>Input: [1, 3, 8, 12, 4, 2] Output: 12 Explanation: The maximum number in the input bitonic
 *     array is 12.
 * @note Solution
 *     <p>A bitonic array is a sorted array; the only difference is that its first part is sorted in
 *     ascending order and the second part is sorted in descending order. We can use a similar
 *     approach as discussed in Order-agnostic Binary Search.
 *     <p>Since no two consecutive numbers are same (as the array is monotonically increasing or
 *     decreasing), whenever we calculate the middle, we can compare the numbers pointed out by the
 *     index middle and middle+1 to find if we are in the ascending or the descending part. So:
 *     <p>f arr[middle] > arr[middle + 1], we are in the second (descending) part of the bitonic
 *     array. Therefore, our required number could either be pointed out by middle or will be before
 *     middle. This means we will be doing: end = middle.
 *     <p>If arr[middle] < arr[middle + 1], we are in the first (ascending) part of the bitonic
 *     array. Therefore, the required number will be after middle. This means we will be doing:
 *     start = middle + 1.
 *     <p>We can break when start == end. Due to the two points mentioned above, both start and end
 *     will be pointing at the maximum number of the bitonic array.
 * @note Time complexity - Since we are reducing the search range by half at every step, this means
 *     that the time complexity of our algorithm will be O(logN) where N is the total elements in
 *     the given array.
 *     <p>
 * @note Space complexity - The algorithm runs in constant space O(1).
 * @author David Kariuki
 * @since 24/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.binary_search;

public class BitonicArrayMaximum {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    System.out.println(BitonicArrayMaximum.findMax(new int[] {1, 3, 8, 12, 4, 2}));
    System.out.println(BitonicArrayMaximum.findMax(new int[] {3, 8, 3, 1}));
    System.out.println(BitonicArrayMaximum.findMax(new int[] {1, 3, 8, 12}));
    System.out.println(BitonicArrayMaximum.findMax(new int[] {10, 9, 8}));
  }

  /**
   * Method to find max in a bitonic array
   *
   * @param nums - int[]
   * @return int
   */
  public static int findMax(int[] nums) {

    int start = 0;
    int end = nums.length - 1;

    while (start < end) {

      int mid = start + ((end - start) / 2); // Calculate mid point

      if (nums[mid] > nums[mid + 1]) {
        end = mid;
      } else if (nums[mid] < nums[mid + 1]) {
        start = mid + 1;
      }
    }

    // At the end of the while loop, 'start == end'
    return nums[start];
  }
}
