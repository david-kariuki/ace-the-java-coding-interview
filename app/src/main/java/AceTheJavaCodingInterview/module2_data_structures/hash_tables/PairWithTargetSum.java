/**
 * PairWithTargetSum Class
 *
 * <p>
 *
 * @question Problem Statement - Given an array of sorted numbers and a target sum, find a pair in
 *     the array whose sum is equal to the given target.
 *     <p>Write a function to return the indices of the two numbers (i.e. the pair) such that they
 *     add up to the given target.
 * @note Example 1:
 *     <p>Input: [1, 2, 3, 4, 6], target=6 Output: [1, 3] Explanation: The numbers at index 1 and 3
 *     add up to 6: 2 + 4 = 6
 * @note Example 2:
 *     <p>Input: [2, 5, 9, 11], target=11 Output: [0, 2] Explanation: The numbers at index 0 and 2
 *     add up to 11: 2 + 9 = 11
 * @note Solution - we can utilize a HashTable to search for the required pair. We can iterate
 *     through the array one number at a time. Let’s say during our iteration we are at number ‘X’,
 *     so we need to find ‘Y’ such that “X + Y == Target”. We will do two things here:
 *     <p>Search for ‘Y’ (which is equivalent to “Target - X Target−X ”) in the HashTable. If it is
 *     there, we have found the required pair. Otherwise, insert “X” in the HashTable, so that we
 *     can search it for the latter numbers.
 *     <p>
 * @note Time Complexity - The time complexity of the above algorithm will be O(N), where N is the
 *     total number of elements in the given array.
 * @note Space Complexity - The algorithm runs in constant space O(1).
 * @author David Kariuki
 * @since 24/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.hash_tables;

import java.util.HashMap;

public class PairWithTargetSum {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] result = PairWithTargetSum.search(new int[] {1, 2, 3, 4, 6}, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.search(new int[] {2, 5, 9, 11}, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
  }

  /**
   * Method to search array
   *
   * @param arr - int[]
   * @param targetSum -
   * @return int[]
   */
  public static int[] search(int[] arr, int targetSum) {

    // HashMap to store numbers and their indices
    HashMap<Integer, Integer> nums = new HashMap<>();

    // Traverse array
    for (int i = 0; i < arr.length; i++) {

      if (nums.containsKey(targetSum - arr[i])) {
        return new int[] {nums.get(targetSum - arr[i]), i};
      } else {
        nums.put(arr[i], i); // put the number and its index in the map
      }
    }

    return new int[] {-1, -1}; // Pair not found
  }
}
