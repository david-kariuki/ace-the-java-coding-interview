/**
 * SearchRotatedArray_Iteratively Class
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

public class SearchRotatedArray_Iteratively {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] targetList = {3, 6, 3, 6};
    int[][] numsList = {
            {6, 7, 1, 2, 3, 4, 5},
            {6, 7, 1, 2, 3, 4, 5},
            {4, 5, 6, 1, 2, 3},
            {4, 5, 6, 1, 2, 3}
    };

    for (int i = 0; i < targetList.length; i++) {

      System.out.println((i + 1) + ". Rotated array: "
              + DataStructuresUtils.arrayToString(numsList[i]));
      System.out.println("   target " + targetList[i] + " found at index "
              + binarySearchRotated(numsList[i], targetList[i]));
      System.out.println("--------------------------\n");
    }
  }

  /**
   * Method to perform binary search
   *
   * <p>
   *
   * @note Time complexity - The time complexity of this solution is O(log n).
   * @note Space complexity - The space complexity of this solution is constant, O(1).
   * @param nums - int[]
   * @param target - int
   */
  public static int binarySearchRotated(int[] nums, int target) {

    int start = 0;
    int end = nums.length - 1;

    if (start > end) {
      return -1;
    }

    while (start <= end) {

      int mid = start + ((end - start) / 2);

      // Target value is present at the middle of the array
      if (target == nums[mid]) {
        return mid;
      }

      // Start to mid is sorted
      if (nums[start] <= nums[mid]) {
        if (nums[start] <= target && target < nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }

      // Mid to end is sorted
      else {
        if (nums[mid] < target && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return -1;
  }
}
