/**
 * Subset Class
 *
 * <p>
 *
 * @question Problem Statement - Given a set with distinct elements, find all of its distinct
 *     subsets.
 *     <p>
 * @note Solution - To generate all subsets of the given set, we can use the Breadth First Search
 *     (BFS) approach. We can start with an empty set, iterate through all numbers one-by-one, and
 *     add them to existing sets to create new subsets.
 *     <p>Let’s take the example-2 mentioned above to go through each step of our algorithm:
 *     <p>Given set: [1, 5, 3]
 *     <p>Start with an empty set: [[]] Add the first number (1) to all the existing subsets to
 *     create new subsets: [[], [1]]; Add the second number (5) to all the existing subsets: [[],
 *     [1], [5], [1,5]]; Add the third number (3) to all the existing subsets: [[], [1], [5], [1,5],
 *     [3], [1,3], [5,3], [1,5,3]].
 *     <p>
 * @note Time complexity - Since, in each step, the number of subsets doubles as we add each element
 *     to all the existing subsets, therefore, we will have a total of O(2^N) subsets, where ‘N’ is
 *     the total number of elements in the input set. And since we construct a new subset from an
 *     existing set, therefore, the time complexity of the above algorithm will be O(N*2^N).
 *     <p>
 * @note Space complexity - All the additional space used by our algorithm is for the output list.
 *     Since we will have a total of O(2^N) O(2 N ) subsets, and each subset can take up to O(N)
 *     space, therefore, the space complexity of our algorithm will be O(N*2^N).
 *     <p>
 * @author David Kariuki
 * @since 23/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import java.util.ArrayList;
import java.util.List;

public class Subset {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    List<List<Integer>> result = Subset.findSubsets(new int[] {1, 3});
    System.out.println("Here is the list of subsets: " + result);

    result = Subset.findSubsets(new int[] {1, 5, 3});
    System.out.println("Here is the list of subsets: " + result);
  }

  /**
   * Method to find subset
   *
   * @param nums - int[]
   * @return List<List<Integer>>
   */
  public static List<List<Integer>> findSubsets(int[] nums) {

    List<List<Integer>> subsets = new ArrayList<>();

    // Start by adding the empty subset
    subsets.add(new ArrayList<>());

    System.out.println("Adding empty to subset.");

    for (int currentNumber : nums) {

      System.out.println();

      // Take all existing subsets and insert the current number in them to
      // create new subsets
      int n = subsets.size();

      for (int i = 0; i < n; i++) {

        // Create a new subset from the existing subsets and insert the
        // current element to it
        List<Integer> set = new ArrayList<>(subsets.get(i));
        System.out.println("Adding current number : " + currentNumber + " to " + "set : " + set);
        set.add(currentNumber);
        System.out.println("Adding set : " + set + " to subset : " + subsets);
        subsets.add(set);
      }
    }

    return subsets;
  }
}
