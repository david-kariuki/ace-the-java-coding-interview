/**
 * TripletSumToZero Class
 *
 * <p>
 *
 * @question Problem Statement - Given an array of unsorted numbers, find all unique triplets in it
 *     that add up to zero.
 *     <p>
 * @example Example 1:
 *     <p>Input: [-3, 0, 1, 2, -1, 1, -2] Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 *     Explanation: There are four unique triplets whose sum is equal to zero. </>
 * @example Example 2:
 *     <p>Input: [-5, 2, -1, -2, 3] Output: [[-5, 2, 3], [-2, -1, 3]] Explanation: There are two
 *     unique triplets whose sum is equal to zero.
 * @solution Solution - This problem follows the Two Pointers pattern and shares similarities with
 *     Pair with Target Sum ({@link
 *     AceTheJavaCodingInterview.module2_data_structures.arrays.PairWithTargetSum}). A couple of
 *     differences are that the input array is not sorted and instead of a pair we need to find
 *     triplets with a target sum of zero.
 *     <p>To follow a similar approach, first, we will sort the array and then iterate through it
 *     taking one number at a time. Let’s say during our iteration we are at number ‘X’, so we need
 *     to find ‘Y’ and ‘Z’ such that X + Y + Z == 0. At this stage, our problem translates into
 *     finding a pair whose sum is equal to -X (as from the above equation Y + Z == -X).
 *     <p>
 *     <p>Another difference from Pair with Target Sum({@link
 *     AceTheJavaCodingInterview.module2_data_structures.arrays.PairWithTargetSum}) is that we need
 *     to find all the unique triplets. To handle this, we have to skip any duplicate number. Since
 *     we will be sorting the array, so all the duplicate numbers will be next to each other and are
 *     easier to skip.
 * @note Time complexity - Sorting the array will take O(N * logN). The searchPair() function will
 *     take O(N). As we are calling searchPair() for every number in the input array, this means
 *     that overall searchTriplets() will take O(N * logN + N^2), which is asymptotically equivalent
 *     to O(N^2).
 * @note Space complexity - Ignoring the space required for the output array, the space complexity
 *     of the above algorithm will be O(N) which is required for sorting.
 * @see AceTheJavaCodingInterview.module2_data_structures.arrays.PairWithTargetSum
 * @see AceTheJavaCodingInterview.module2_data_structures.hash_tables.PairWithTargetSum
 * @author David Kariuki
 * @since 25/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    System.out.println(TripletSumToZero.searchTriplets(new int[] {-3, 0, 1, 2, -1, 1, -2}));
    System.out.println(TripletSumToZero.searchTriplets(new int[] {-5, 2, -1, -2, 3}));
  }

  /**
   * Method to search for triplets
   *
   * @param arr - int[]
   * @return List<List<Integer>>
   */
  public static List<List<Integer>> searchTriplets(int[] arr) {

    Arrays.sort(arr); // Sort array

    List<List<Integer>> triplets = new ArrayList<>();

    // Traverse array
    for (int i = 0; i < arr.length - 2; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue; // Skip element to avoid duplicate triplets
      }

      searchPair(arr, -arr[i], i + 1, triplets); // Search pair
    }

    return triplets;
  }

  /**
   * Method to search for triplets
   *
   * @param arr - int[]
   * @param targetSum - int
   * @param left - int
   * @param triplets - List<List<Integer>>
   */
  public static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {

    int right = arr.length - 1;

    while (left < right) {

      int currentSum = arr[left] + arr[right];

      if (currentSum == targetSum) {

        // Found the triplet
        triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
        left++;
        right--;

        while (left < right && arr[left] == arr[left - 1]) {
          left++; // Skip same element to avoid duplicate triplets
        }

        while (left < right && arr[right] == arr[right + 1]) {
          right--; // Skip same element to avoid duplicate triplets
        }
      } else if (targetSum > currentSum) {
        left++; // Pair with a bigger sum
      } else {
        right--; // Pair with a smaller sum
      }
    }
  }
}
