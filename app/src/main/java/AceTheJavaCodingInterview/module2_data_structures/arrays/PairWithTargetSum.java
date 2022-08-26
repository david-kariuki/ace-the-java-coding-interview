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
 * @note Solution - Since the given array is sorted, a brute-force solution could be to iterate
 *     through the array, taking one number at a time and searching for the second number through
 *     Binary Search. The time complexity of this algorithm will be O(N*logN). Can we do better than
 *     this?
 *     <p>
 *     <p>We can follow the Two Pointers approach. We will start with one pointer pointing to the
 *     beginning of the array and another pointing at the end. At every step, we will see if the
 *     numbers pointed by the two pointers add up to the target sum. If they do, we have found our
 *     pair; otherwise, we will do one of two things:
 *     <p>1. If the sum of the two numbers pointed by the two pointers is greater than the target
 *     sum, this means that we need a pair with a smaller sum. So, to try more pairs, we can
 *     decrement the end-pointer.
 *     <p>2. If the sum of the two numbers pointed by the two pointers is smaller than the target
 *     sum, this means that we need a pair with a larger sum. So, to try more pairs, we can
 *     increment the start-pointer.
 *     <p>
 * @note Time Complexity - The time complexity of the above algorithm will be O(N), where N is the
 *     total number of elements in the given array.
 * @note Space Complexity - The space complexity will also be O(N), as, in the worst case, we will
 *     be pushing N numbers in the HashTable.
 * @author David Kariuki
 * @since 24/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

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

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {

      int currentSum = arr[left] + arr[right];

      // Check if current sum equals target sum
      if (currentSum == targetSum) {
        return new int[] {left, right};
      }

      // Compare current and target sum
      if (currentSum > targetSum) {
        right--; // We need a pair with a smaller sum
      } else {
        left++; // We need a pair with a bigger sum
      }
    }

    return new int[] {-1, -1}; // Return int pair with -1
  }
}
