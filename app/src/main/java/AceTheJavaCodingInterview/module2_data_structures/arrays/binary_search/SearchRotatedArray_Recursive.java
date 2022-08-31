/**
 * SearchRotatedArray_Recursive Class
 *
 * <p>
 *
 * @question Search for a given number in a sorted array that has been rotated by some arbitrary
 *     number. We're given a sorted integer array, nums and an integer value, target. The array is
 *     rotated by some arbitrary number. Search the target in this array. If the target does not
 *     exist then return -1.
 * @author David Kariuki
 * @since 18/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.binary_search;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class SearchRotatedArray_Recursive {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] targetList = {3, 6, 3, 6};
    int[][] numsList = {
      {6, 7, 1, 2, 3, 4, 5}, {6, 7, 1, 2, 3, 4, 5}, {4, 5, 6, 1, 2, 3}, {4, 5, 6, 1, 2, 3}
    };

    for (int i = 0; i < targetList.length; i++) {

      System.out.println(
          (i + 1) + ". Rotated array: " + DataStructuresUtils.arrayToString(numsList[i]));
      System.out.println(
          "   target "
              + targetList[i]
              + " found at index "
              + binarySearchRotated(numsList[i], targetList[i]));
      System.out.println("------------------\n");
    }
  }

  /**
   * Method to perform binary search
   *
   * @param nums - int[]
   * @param target - int
   */
  static int binarySearchRotated(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  /**
   * Method to perform binary search
   *
   * <p>
   *
   * @note Time complexity - The time complexity of this solution is O(log n).
   * @note Space complexity - The space complexity of this solution is logarithmic, O(log n) .
   * @param nums - int[]
   * @param start - int
   * @param end - int
   * @param target - int
   */
  public static int binarySearch(int[] nums, int start, int end, int target) {

    if (start > end) {
      return -1;
    }

    int mid = start + ((end - start) / 2);

    // Target value is present at the middle of the array
    if (target == nums[mid]) {
      return mid;
    }

    // Start to mid is sorted
    if (nums[start] <= nums[mid]) {
      if (nums[start] <= target && target < nums[mid]) {
        binarySearch(nums, start, mid - 1, target);
      } else {
        binarySearch(nums, mid + 1, end, target);
      }
    }

    // Mid to end is sorted
    else {
      if (nums[mid] < target && target <= nums[end]) {
        binarySearch(nums, mid + 1, end, target);
      } else {
        binarySearch(nums, start, mid - 1, target);
      }
    }

    return -1;
  }
}
