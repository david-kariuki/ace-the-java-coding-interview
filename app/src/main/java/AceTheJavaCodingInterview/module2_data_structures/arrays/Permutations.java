/**
 * Permutations Class
 *
 * <p>
 *
 * @question Problem Statement# Given a set of distinct numbers, find all of its permutations.
 *     <p>Permutation is defined as the re-arranging of the elements of the set.
 * @note Example, {1, 2, 3} has the following six permutations:
 *     <p>{1, 2, 3} {1, 3, 2} {2, 1, 3} {2, 3, 1} {3, 1, 2} {3, 2, 1}
 *     <p>If a set has ‘n’ distinct elements it will have n! n! permutations.
 * @note Solution This problem follows the Subsets pattern and, we can follow a similar Breadth
 *     First Search (BFS) approach. However, unlike Subsets, every permutation must contain all the
 *     numbers.
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
 *     new permutations. For example, inserting ‘5’ in different positions of [3,1] will give us the
 *     following permutations:
 *     <p>Inserting ‘5’ before ‘3’: [5,3,1]
 *     <p>Inserting ‘5’ between ‘3’ and ‘1’: [3,5,1]
 *     <p>Inserting ‘5’ after ‘1’: [3,1,5]
 * @author David Kariuki
 * @since 24/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import java.util.ArrayList;
import java.util.List;

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
  private static List<List<Integer>> findPermutations(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    return result;
  }
}
