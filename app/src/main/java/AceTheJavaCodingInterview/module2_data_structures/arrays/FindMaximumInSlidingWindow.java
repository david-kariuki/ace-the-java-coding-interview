/**
 * FindMaximumInSlidingWindow Class
 *
 * <p>
 *
 * @question Given an array of integers, find the maximum value in a window. Given an integer array
 *     and a window of size w, find the current maximum value in the window as it slides through the
 *     entire array.
 * @note If the window size is greater than the array size, we will consider the entire array as a
 *     single window.
 * @author David Kariuki
 * @since 17/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindMaximumInSlidingWindow {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] targetList = {3, 2, 1, 2};
    int[][] numsList = {
      {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
      {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
      {4, 5, 6, 1, 2, 3},
      {9, 5, 3, 1, 6, 3}
    };

    for (int i = 0; i < targetList.length; i++) {

      System.out.println(
          (i + 1) + ". Original list:\t" + DataStructuresUtils.arrayToString(numsList[i]));
      System.out.println("   Window size:\t\t" + targetList[i]);

      ArrayDeque<Integer> ouput = findMaxSlidingWindow(numsList[i], targetList[i]);

      System.out.println("   Max:\t\t\t" + ouput);
      System.out.println("------------------------------------------------\n");
    }
  }

  /**
   * Method to find max sliding window
   *
   * <p>
   *
   * @note Time complexity - The time complexity of this solution is O(n) O(n).
   * @note Every element is pushed and popped from the deque only once in a single traversal.
   * @note Space complexity - The space complexity of this solution is O(w), where w is the window
   *     size in this case.
   * @param arr - int[]
   * @return ArrayDeque<Integer>
   */
  @SuppressWarnings("ConstantConditions")
  public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {

    // ArrayDeque for storing values
    ArrayDeque<Integer> result = new ArrayDeque<>();
    Deque<Integer> list = new ArrayDeque<>(); // Create a LinkedList

    if (arr.length > 0) {

      // If window_size is greater than the array size,
      // set the window_size to arr.size()
      if (arr.length < windowSize) {
        windowSize = arr.length;
      }

      for (int i = 0; i < windowSize; ++i) {
        // Removing last smallest element index
        while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
          list.removeLast();
        }

        // Adding newly picked element index
        list.addLast(i);
      }
      for (int i = windowSize; i < arr.length; ++i) {
        result.add(arr[list.peek()]);

        // Removing all the elements indexes which are not in the current window
        while ((!list.isEmpty()) && list.peek() <= i - windowSize) list.removeFirst();

        // Removing the smaller elements indexes which are not required
        while ((!list.isEmpty()) && arr[i] >= arr[list.peekLast()]) list.removeLast();

        // Adding newly picked element index
        list.addLast(i);
      }

      // Adding the max number of the current window in the result
      result.add(arr[list.peek()]);
    }

    return result; // returning result
  }
}
