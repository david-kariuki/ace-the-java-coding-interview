/**
 * MoveAllZerosToTheBeginningOfTheArray Class
 *
 * <p>
 *
 * @question Move all zeros to the left of an array while maintaining its order.
 * @author David Kariuki
 * @since 18/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.binary_search;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class MoveAllZerosToTheBeginningOfTheArray {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[][] numsList = {
      {1, 10, 20, 0, 59, 63, 0, 88, 0},
      {1, 0, 2, 3, 0},
      {0},
      {-1, 0, 0, -2, 9},
      {1, 2, 3, 4, 5},
      {2}
    };

    for (int i = 0; i < numsList.length; i++) {
      DataStructuresUtils.printOutArray(numsList[i], (i + 1) + ". Before list: ");
      moveZerosToLeft(numsList[i]);
      DataStructuresUtils.printOutArray(numsList[i], "After list:\t");
      System.out.println("-------------------------\n");
    }
  }

  /**
   * @explanation - Solution. We will use Read and Write pointers and start by pointing them to the
   *     end of the array.
   *     <p>While moving the Read pointer towards the start of the array:
   *     <p>If the value at the Read pointer is 0, decrement the Read pointer. If the value at the
   *     Read pointer is non-zero, set the value at the - Write pointer equal to the value at the
   *     Read pointer, and decrement the - Write and Read pointers. Once, the Read pointer reaches
   *     the 0th index, start assigning zeros to all the values from the - Write pointer back to the
   *     0th index.
   * @note Time complexity - The time complexity of this solution is O(n).
   *     <p>
   * @note Space complexity - The space complexity of this solution is O(1).
   */
  static void moveZerosToLeft(int[] nums) {

    // Initialize markers
    int writeIndex = nums.length - 1;
    int readIndex = nums.length - 1;

    // Iterate readIndex marker till the index is less than or equal to zero
    while (readIndex >= 0) {
      // Replacing write_index value with read_index value. This step moves
      // the next non-zero value "back" in the array, making space for the
      // zero at the head of the array
      if (nums[readIndex] != 0) {
        nums[writeIndex] = nums[readIndex];
        writeIndex--;
      }

      readIndex--;
    }

    // Replacing initial values with zeroes
    while (writeIndex >= 0) {
      nums[writeIndex] = 0;
      writeIndex--;
    }
  }
}
