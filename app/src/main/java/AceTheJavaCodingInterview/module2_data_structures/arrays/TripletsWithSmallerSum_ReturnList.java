/**
 * TripletsWithSmallerSum_ReturnList Class
 *
 * <p>
 *
 * @question Problem Statement - Given an array arr of unsorted numbers and a target sum, count all
 *     triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
 *     different indices. Write a function to return the count of such triplets.
 * @example Example 1:
 *     <p>Input: [-1, 0, 2, 3], target=3 Output: 2 Explanation: There are two triplets whose sum is
 *     less than the target: [-1, 0, 3], [-1, 0, 2]
 * @example Example 2:
 *     <p>Input: [-1, 4, 2, 1, 3], target=5 Output: 4 Explanation: There are four triplets whose sum
 *     is less than the target: [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 * @note Solution - This problem follows the Two Pointers pattern and shares similarities with
 *     Triplet Sum to Zero ({@link
 *     AceTheJavaCodingInterview.module2_data_structures.arrays.TripletSumToZero}). The only
 *     difference is that, in this problem, we need to find the triplets whose sum is less than the
 *     given target. To meet the condition i != j != k we need to make sure that each number is not
 *     used more than once.
 *     <p>Following a similar approach, first, we can sort the array and then iterate through it,
 *     taking one number at a time. Let’s say during our iteration we are at number ‘X’, so we need
 *     to find ‘Y’ and ‘Z’ such that X + Y + Z < target X+Y+Z<target . At this stage, our problem
 *     translates into finding a pair whose sum is less than target - X (as from the above equation
 *     Y + Z == target - X Y+Z==target−X ). We can use a similar approach as discussed in Triplet
 *     Sum to Zero.
 * @note Time Complexity - Sorting the array will take O(N * logN). The searchPair() will take O(N).
 *     So, overall searchTriplets() will take O(N * logN + N^2), which is asymptotically equivalent
 *     to O(N^2).
 * @note Space Complexity - The space complexity of the above algorithm will be O(N) O(N) which is
 *     required for sorting if we are not using an in-place sorting algorithm.
 * @author David Kariuki
 * @since 26/8/2022
 * @see AceTheJavaCodingInterview.module2_data_structures.arrays.TripletSumToZero
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import java.util.Arrays;

public class TripletsWithSmallerSum_ReturnList {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {
    System.out.println(
        TripletsWithSmallerSum_ReturnList.searchTriplets(new int[] {-1, 0, 2, 3}, 3));
    System.out.println(
        TripletsWithSmallerSum_ReturnList.searchTriplets(new int[] {-1, 4, 2, 1, 3}, 5));
  }

  /**
   * Method to search for triplets
   *
   * @param arr - int[]
   * @param target - int
   * @return int
   */
  public static int searchTriplets(int[] arr, int target) {

    Arrays.sort(arr); // Sort array

    int count = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      count += searchPair(arr, target - arr[i], i);
    }

    return count; // Return count
  }

  /**
   * Method to search for pairs
   *
   * @param arr - int[]
   * @param targetSum - int
   * @param first - int
   */
  public static int searchPair(int[] arr, int targetSum, int first) {

    int count = 0;
    int left = first + 1;
    int right = arr.length - 1;

    while (left < right) {
      if ((arr[left] + arr[right]) < targetSum) {
        // Found the triplet. Since arr[right] >= arr[left], therefore, we can
        // replace arr[right] by any number between left and right to get a sum
        // less than the target sum
        count += right - left;
        left++;
      } else {
        right--; // Need a pair with a smaller sum
      }
    }

    return count; // Return count
  }
}
