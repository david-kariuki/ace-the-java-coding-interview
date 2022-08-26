/**
 * BinarySearchOnSortedArray_Recursive Class
 *
 * <p>
 *
 * @question We are given an array of integers, nums, sorted in ascending order, and an integer *
 *     value, target. If the target exists in the array, return its index. If the target does not *
 *     exist, then return -1.
 *     This class uses Recursion.
 * @author David Kariuki
 * @since 17/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.binary_search;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class BinarySearchOnSortedArray_Recursive {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[][] numsLists = {{}, {0, 1}, {1, 2, 3}, {-1, 0, 3, 5, 9, 12}, {-1, 0, 3, 5, 9, 12}};
    int[] targetList = {12, 1, 3, 9, 2};

    for (int i = 0; i < numsLists.length; i++) {

      int[] nums = numsLists[i];
      int target = targetList[i];
      int index = binarySearch(nums, target);

      System.out.println(i + 1 + ". Array to search: " + DataStructuresUtils.arrayToString(nums));
      System.out.println("   Target: " + targetList[i]);

      if (index != -1) {
        System.out.println("   " + target + " exists in the array and its index is " + index);
      } else {
        System.out.println(
            "   " + target + " does not exist in the array so the return value is " + index);
      }
    }
  }

  /**
   * Method to perform binary search
   *
   * <p>
   *
   * @note Time complexity - The time complexity of this solution is logarithmic, O(log n)
   * @note Space complexity - The space complexity of this solution is constant, O(1).
   * @param nums - int[]
   * @param target - int
   * @return int
   */
  public static int binarySearch(int[] nums, int target) {
    return binarySearchRecursive(nums, target, 0, nums.length - 1);
  }

  /**
   * Method to perform binary search
   *
   * <p>
   *
   * @note Time complexity - The time complexity of this solution is logarithmic, O(log n)
   * @note Space complexity - The space complexity of this solution is constant, O(1).
   * @param nums - int[]
   * @param target - int
   * @param low - int
   * @param high - int
   * @return int
   */
  public static int binarySearchRecursive(int[] nums, int target, int low, int high) {

    if (low > high) {
      return -1;
    }

    // Finding the mid using floor division
    int mid = low + ((high - low) / 2);

    // Target value is present at the middle of the array
    if (nums[mid] == target) {
      return mid;
    }

    // Target value is present in the low subarray
    else if (target < nums[mid]) {
      binarySearchRecursive(nums, target, low, mid - 1);

      // Target value is present in the high subarray
    } else if (target > nums[mid]) {
      binarySearchRecursive(nums, target, mid + 1, high);
    }

    // Target value is not present in the array
    return -1;
  }
}
