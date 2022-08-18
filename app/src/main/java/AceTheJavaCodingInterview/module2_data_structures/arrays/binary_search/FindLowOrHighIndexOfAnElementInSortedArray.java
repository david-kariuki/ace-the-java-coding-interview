/**
 * FindLowOrHighIndexOfAnElementInSortedArray Class
 *
 * <p>
 *
 * @question We’re given a sorted array of integers, nums, and an integer value, target. Return the
 *     low and high index of the given target element. If the indexes are not found, return -1.
 * @note The array can contain multiple duplicates with length in millions.
 * @example int array -> {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20}
 *     <p>For target= 1: low = 0 and high = 0
 *     <p>For target= 2: low = 1 and high = 1
 *     <p>For target= 5: low = 2 and high = 9
 *     <p>
 *     <p>Linearly scanning the sorted array for low and high indices is highly inefficient since
 *     our array size can be in the millions. Instead, we will use a slightly modified binary search
 *     to find the low and high indices of a given target.
 * @author David Kariuki
 * @since /8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.binary_search;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

@SuppressWarnings("ALL")
public class FindLowOrHighIndexOfAnElementInSortedArray {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr =
        new int[] {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 9};

    int target = 5;

    DataStructuresUtils.printOutArray(arr);

    System.out.println(
        "The low index of target : " + target + " is : " + findLowIndex(arr, target));
    System.out.println();

    System.out.println(
        "The high index of target : " + target + " is : " + findHighIndex(arr, target));
    System.out.println();
  }

  /**
   * Method to find low index
   *
   * <p>
   *
   * @note Time complexity - Since we are using binary search, the time complexity is logarithmic,
   *     O(logn). Even though we do the binary search twice, the asymptotic time complexity is still
   *     O(logn).
   *     <p>
   * @note Space complexity - The space complexity is constant, O(1) O (1) , since no extra storage
   *     is used.
   * @param nums - int[]
   * @param target - int
   * @return int
   */
  static int findLowIndex(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int mid = high / 2;

    while (low <= high) {
      int midElem = nums[mid];

      // Target value is less than the middle value
      if (midElem < target) {
        low = mid + 1;
      }

      // Target value is greater than or equal to the middle value
      else {
        high = mid - 1;
      }

      // Updating the mid value
      mid = low + (high - low) / 2;
    }

    if (low < nums.length && nums[low] == target) {
      return low;
    }

    return -1;
  }

  /**
   * Method to find high index
   *
   * <p>
   *
   * @note Time complexity - Since we are using binary search, the time complexity is logarithmic,
   *     O(logn). Even though we do the binary search twice, the asymptotic time complexity is still
   *     O(logn).
   *     <p>
   * @note Space complexity - The space complexity is constant, O(1) O (1) , since no extra storage
   *     is used.
   * @param nums - int[]
   * @param target - int
   * @return int
   */
  static int findHighIndex(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int mid = high / 2;

    while (low <= high) {

      int midElem = nums[mid];

      // Target value is less than or equal to the middle value
      if (midElem <= target) {
        low = mid + 1;
      }

      // Target value is greater than the middle value
      else {
        high = mid - 1;
      }

      // Updating the mid value
      mid = low + (high - low) / 2;
    }

    if (high == -1) {
      return high;
    }

    if (high < nums.length && nums[high] == target) {
      return high;
    }

    return -1;
  }
}
