/**
 * BinarySearchOnSortedArray_Iterative Class
 *
 * <p>
 *
 * @question We are given an array of integers, nums, sorted in ascending order, and an integer
 *     value, target. If the target exists in the array, return its index. If the target does not
 *     exist, then return -1. This class uses Iteration.
 * @author David Kariuki
 * @since 17/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.binary_search;

public class BinarySearchOnSortedArray_Iterative {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] nums = new int[] {1, 3, 9, 10, 12};
    int target = 9;
  }

  /**
   * Method to perform binary search
   *
   * <p>
   *
   * @note Time complexity - The time complexity of this solution is logarithmic, O(log n)
   * @note Space complexity - The space complexity of this solution is logarithmic, O(log n) because
   *     the recursive approach consumes memory on the stack.
   * @param nums - int[]
   * @param target - int
   * @return int
   */
  static int binarySearch(int[] nums, int target) {

    // Set start
    int start = 0;
    int end = nums.length - 1;

    for (int i = 0; i < nums.length; i++) {

      // Finding the mid using floor division
      // Using this method to prevent an overflow
      int mid = start + ((end - start) / 2);

      // Target value is present at the middle of the array
      if (nums[mid] == target) {
        return nums[mid];

        // Target value is present in the low subarray
      } else if (nums[mid] > target) {
        end = mid - 1;

        // Target value is present in the high subarray
      } else if (target > nums[mid]) {
        start = mid + 1;
      }
    }

    return -1;
  }
}
