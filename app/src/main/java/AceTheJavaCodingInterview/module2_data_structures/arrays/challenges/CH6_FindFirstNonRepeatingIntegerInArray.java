/**
 * CH6_FindFirstNonRepeatingIntegerInArray Class
 *
 * <p>
 *
 * @note Given an array, find the first integer, which is unique in the array.
 * Unique means the number does not repeat and appears only once in the
 * whole array.
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH6_FindFirstNonRepeatingIntegerInArray {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr = {2, 54, 7, 2, 6, 54};

    System.out.println("Array: " + DataStructuresUtils.arrayToString(arr));

    int unique = findFirstUnique(arr);
    System.out.print("First Unique in an Array: " + unique);
  }

  /**
   * Method to find first unique element
   *
   * <p>
   *
   * @note The time complexity of this solution is O(n^2) since the entire list is iterated for each
   *     element n*n times.
   * @param arr - int[]
   */
  public static int findFirstUnique(int[] arr) {

    // Inside Inner Loop Check Each index of outerLoop If it is repeated in
    // array. If it's not repeated then return this as first unique Integer
    boolean numRepeated = false;

    // Traverse array
    for (int i = 0; i < arr.length; i++) {

      // Traverse array
      for (int j = 0; j < arr.length; j++) {

        if (i != j) {
          if (arr[i] == arr[j]) {
            numRepeated = true;
            break;
          } else {
            numRepeated = false;
          }
        }
      }

      if (!numRepeated) {
        return arr[i];
      }
    }

    return -1;
  }
}
