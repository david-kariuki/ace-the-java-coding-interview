/**
 * QuicksortAlgorithm Class
 *
 * <p>
 *
 * @question Given an integer array, sort it in ascending order using quicksort.
 * @note Solution Here is an overview of how the quicksort algorithm works:
 *     <p>Select a pivot element from the array to divide it into two parts. We pick the first
 *     element as the pivot if we follow Hoare’s algorithm. Another common approach is to select a
 *     random element as the pivot.
 *     <p>Reorder the array by comparing elements with the pivot element such that smaller values
 *     end up on the left side and larger values end up on the right side of the pivot.
 *     <p>Now, the pivot element is in its correct sorted position. By applying the above steps, we
 *     can recursively sort the sublists on the right and left sides of the pivot.
 * @note Time complexity - The time complexity of this solution is linearithmic, O(n logn).
 * @note Space complexity - The space complexity of this solution is logarithmic, O(logn), because
 *     it consumes memory on the stack.
 * @author David Kariuki
 * @since 23/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.sorting;

import java.util.Arrays;

public class QuicksortAlgorithm {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[][] numsList = {
      {55, 23, 26, 2, 18, 78, 23, 8, 2, 3}, {1}, {9, 8, 7, 2, 3, 1}, {10, 20, 30, -1, -2}
    };

    for (int i = 0; i < numsList.length; i++) {

      System.out.println((i + 1) + ". Before Sorting");
      System.out.println("   " + Arrays.toString(numsList[i]));

      quickSort(numsList[i]);

      System.out.println("   After Sorting");
      System.out.println("   " + Arrays.toString(numsList[i]));
      System.out.println("------------------------------------------------\n");
    }
  }

  /**
   * Method to perform quick sort using Hoare's partitioning scheme
   *
   * @param arr - int[]
   * @param low - int
   * @param high - int
   */
  static int partition(int[] arr, int low, int high) {

    // [55, 23, 26, 2, 25]

    // Initializing pivot's index to low
    int pivotValue = arr[low];
    int i = low;
    int j = high;

    // Loop until i pointer crosses j pointer
    while (i < j) {

      // Increment the 'i' pointer till it finds an element greater than pivot
      while (i <= high && arr[i] <= pivotValue) {
        i++;
      }

      // Decrement the 'j' pointer till it finds an element less than pivot
      while (arr[j] > pivotValue) {
        j--;
      }

      // Swap the numbers on i and j
      if (i < j) {
        // Swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // Swap pivot element with element on j pointer
    arr[low] = arr[j];
    arr[j] = pivotValue;

    return j; // return the pivot index
  }

  /**
   * Recursive function to implement QuickSort
   *
   * @param arr - int[]
   * @param low - int
   * @param high - int
   */
  static void quickSortRec(int[] arr, int low, int high) {

    if (high > low) {

      // Pivot index is the partitioning index
      int pivotIndex = partition(arr, low, high);

      // Sort elements before partition
      quickSortRec(arr, low, pivotIndex - 1);

      // Sort elements after partition
      quickSortRec(arr, pivotIndex + 1, high);
    }
  }

  /**
   * Method to perform quicksort
   *
   * @param arr - int[]
   */
  static void quickSort(int[] arr) {
    quickSortRec(arr, 0, arr.length - 1);
  }
}
