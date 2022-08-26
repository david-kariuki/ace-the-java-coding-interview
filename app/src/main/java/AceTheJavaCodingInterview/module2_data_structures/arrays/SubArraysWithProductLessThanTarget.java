/**
 * SubArraysWithProductLessThanTarget Class
 *
 * <p>
 *
 * @question Problem Statement - Given an array with positive numbers and a positive target number,
 *     find all of its contiguous sub-arrays whose product is less than the target number.
 * @example Example 1:
 *     <p>Input: [2, 5, 3, 10], target=30 Output: [2], [5], [2, 5], [3], [5, 3], [10] Explanation:
 *     There are six contiguous sub-arrays whose product is less than the target.
 * @example Example 2:
 *     <p>Input: [8, 2, 6, 5], target=50 Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 *     Explanation: There are seven contiguous sub-arrays whose product is less than the target.
 * @note Solution - This problem follows the Sliding Window and the Two Pointers pattern and shares
 *     similarities with Triplets with Smaller Sum
 *     <p>({@link
 *     AceTheJavaCodingInterview.module2_data_structures.arrays.TripletsWithSmallerSum_ReturnCount},
 *     {@link
 *     AceTheJavaCodingInterview.module2_data_structures.arrays.TripletsWithSmallerSum_ReturnList})
 *     with two differences:
 *     <p>In this problem, the input array is not sorted. Instead of finding triplets with sum less
 *     than a target, we need to find all sub-arrays having a product less than the target. The
 *     implementation will be quite similar to Triplets with Smaller Sum.
 * @note Time Complexity -
 * @note Space Complexity -
 * @author David Kariuki
 * @since 26/8/2022
 * @see AceTheJavaCodingInterview.module2_data_structures.arrays.TripletsWithSmallerSum_ReturnCount
 * @see AceTheJavaCodingInterview.module2_data_structures.arrays.TripletsWithSmallerSum_ReturnList
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubArraysWithProductLessThanTarget {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {
    System.out.println(
        SubArraysWithProductLessThanTarget.findSubArrays(new int[] {2, 5, 3, 10}, 30));
    System.out.println(
        SubArraysWithProductLessThanTarget.findSubArrays(new int[] {8, 2, 6, 5}, 50));
  }

  /**
   * Method to find sub arrays
   *
   * @param arr - int[]
   * @param target - int
   * @return List<List<Integer>>
   */
  public static List<List<Integer>> findSubArrays(int[] arr, int target) {

    List<List<Integer>> result = new ArrayList<>();

    double product = 1;
    int left = 0;

    // Traverse array
    for (int right = 0; right < arr.length; right++) {

      product *= arr[right];

      while (product >= target && left < arr.length) {
        product /= arr[left++];
      }

      // Since the product of all numbers from left to right is less than the
      // target therefore, all sub-arrays from left to right will have a
      // product less than the target too; to avoid duplicates, we will start
      // with a sub-array containing only arr[right] and then extend it.
      List<Integer> tempList = new LinkedList<>();

      for (int i = right; i >= left; i--) {
        tempList.add(0, arr[i]);
        result.add(new ArrayList<>(tempList));
      }
    }

    return result;
  }
}
