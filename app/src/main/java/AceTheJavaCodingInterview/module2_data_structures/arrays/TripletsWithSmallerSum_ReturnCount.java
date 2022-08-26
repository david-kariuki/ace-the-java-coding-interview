/**
 * TripletsWithSmallerSum_ReturnCount Class
 *
 * <p>
 *
 * @question Problem Statement - Write a function to return the list of all such triplets instead of
 *     the count. How will the time complexity change in this case?
 * @note Solution - Following a similar approach we can create a list containing all the triplets.
 *     Another simpler approach could be to check every triplet of the array with three nested loops
 *     and create a list of triplets that meet the required condition.
 * @note Time Complexity - Sorting the array will take O(N * logN). The searchPair(), in this case,
 *     will take O(N^2). The main while loop will run in O(N)but the nested for loop can also take
 *     O(N) - this will happen when the target sum is bigger than every triplet in the array.
 *     <p>So, overall searchTriplets() will take O(N * logN + N^3), which is asymptotically
 *     equivalent to O(N^3).
 * @note Space Complexity - Ignoring the space required for the output array, the space complexity
 *     of the above algorithm will be O(N) which is required for sorting.
 * @author David Kariuki
 * @since 26/8/2022
 * @see AceTheJavaCodingInterview.module2_data_structures.arrays.TripletSumToZero
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSmallerSum_ReturnCount {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {
    System.out.println(
        TripletsWithSmallerSum_ReturnCount.searchTriplets(new int[] {-1, 0, 2, 3}, 3));
    System.out.println(
        TripletsWithSmallerSum_ReturnCount.searchTriplets(new int[] {-1, 4, 2, 1, 3}, 5));
  }

  /**
   * Method to search for triplets
   *
   * @param arr - int[]
   * @param target - int
   * @return List<List<Integer>>
   */
  public static List<List<Integer>> searchTriplets(int[] arr, int target) {

    Arrays.sort(arr); // Sort array

    List<List<Integer>> triplets = new ArrayList<>();

    for (int i = 0; i < arr.length - 2; i++) {
      searchPair(arr, target - arr[i], i, triplets);
    }

    return triplets;
  }

  /**
   * Method to search for pairs
   *
   * @param arr - int[]
   * @param targetSum - int
   * @param first - int
   * @param triplets - List<List<Integer>>
   */
  public static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {

    int left = first + 1;
    int right = arr.length - 1;

    while (left < right) {

      if (arr[left] + arr[right] < targetSum) {
        // Found the triplet. Since arr[right] >= arr[left], therefore, we can
        // replace arr[right] by any number between left and right to get a sum
        // less than the target sum

        for (int i = right; i > left; i--) {
          triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
        }

        left++;

      } else {
        right--; // Need a pair with a  smaller sum
      }
    }
  }
}
