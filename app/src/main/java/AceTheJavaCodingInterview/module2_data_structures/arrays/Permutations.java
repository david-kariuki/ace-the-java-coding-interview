/**
 * Permutations Class
 *
 * <p>
 *
 * @question Problem Statement# Given a set of distinct numbers, find all of its permutations.
 *     <p>Permutation is defined as the re-arranging of the elements of the set.
 * @note Example, {1, 2, 3} has the following six permutations:
 *     <p>{1, 2, 3} {1, 3, 2} {2, 1, 3} {2, 3, 1} {3, 1, 2} {3, 2, 1}
 *     <p>If a set has n distinct elements it will have n! n! permutations.
 * @note Solution This problem follows the Subsets pattern ({@link
 *     AceTheJavaCodingInterview.module2_data_structures.arrays.Subset}) and, we can follow a
 *     similar Breadth First Search (BFS) approach. However, unlike Subsets, every permutation must
 *     contain all the numbers.
 *     <p>Let’s take the example-1 mentioned above to generate all the permutations. Following a BFS
 *     approach, we will consider one number at a time:
 *     <p>1. If the given set is empty then we have only an empty permutation set: []
 *     <p>2. Let’s add the first element (1), the permutations will be: [1]
 *     <p>3. Let’s add the second element (3), the permutations will be: [3,1], [1,3]
 *     <p>4. Let’s add the third element (5), the permutations will be: [5,3, 1], [3,5,1], [3,1,5],
 *     [5,1,3], [1,5,3], [1,3,5]
 *     <p>
 *     <p>Let’s analyze the permutations in the 3rd and 4th steps. How can we generate permutations
 *     in the 4th step from the permutations of the 3rd step?
 *     <p>If we look closely, we will realize that when we add a new number (5), we take each
 *     permutation of the previous step and insert the new number in every position to generate the
 *     new permutations. For example, inserting 5 in different positions of [3,1] will give us the
 *     following permutations:
 *     <p>Inserting 5 before 3: [5,3,1]
 *     <p>Inserting 5 between 3 and 1: [3,5,1]
 *     <p>Inserting 5 after 1: [3,1,5]
 *     <p>
 * @note Time complexity - We know that there are a total of N! permutations of a set with N
 *     numbers. In the algorithm above, we are iterating through all of these permutations with the
 *     help of the two for loops. In each iteration, we go through all the current permutations to
 *     insert a new number in them. To insert a number into a permutation of size N will take O(N),
 *     which makes the overall time complexity of our algorithm O(N*N!).
 * @note Space complexity - All the additional space used by our algorithm is for the result list
 *     and the queue to store the intermediate permutations. If you see closely, at any time, we
 *     don’t have more than N! permutations between the result list and the queue. Therefore, the
 *     overall space complexity to store N! permutations each containing N elements will be O(N*N!).
 * @see AceTheJavaCodingInterview.module2_data_structures.arrays.Subset
 * @see AceTheJavaCodingInterview.module2_data_structures.arrays.SubsetsWithDuplicates
 * @author David Kariuki
 * @since 24/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    List<List<Integer>> result = Permutations.findPermutations(new int[] {1, 3, 5});
    System.out.print("Here are all the permutations: " + result);
  }

  /**
   * Method to find permutation of an array
   *
   * @param nums - int[]
   * @return List<List<Integer>>
   */
  @SuppressWarnings("ConstantConditions")
  public static List<List<Integer>> findPermutations(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    Queue<List<Integer>> permutations = new LinkedList<>();
    permutations.add(new ArrayList<>());

    for (int currentNumber : nums) {

      // Take all existing permutations and add the current number to create new
      // permutations
      int n = permutations.size();

      for (int i = 0; i < n; i++) {
        List<Integer> oldPermutation = permutations.poll();

        // create a new permutation by adding the current number at every position
        for (int j = 0; j <= oldPermutation.size(); j++) {

          List<Integer> newPermutation = new ArrayList<>(oldPermutation);
          newPermutation.add(j, currentNumber);

          if (newPermutation.size() == nums.length) {
            result.add(newPermutation);
          } else {
            permutations.add(newPermutation);
          }
        }
      }
    }
    return result;
  }
}
