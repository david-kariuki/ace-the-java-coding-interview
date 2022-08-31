/**
 * CyclicSortEasy Class
 *
 * <p>
 *
 * @question Problem Statement - We are given an array containing n objects. Each object, when
 *     created, was assigned a unique number from the range 1 to n based on their creation sequence.
 *     This means that the object with sequence number 3 was created just before the object with
 *     sequence number 4.
 *     <p>Write a function to sort the objects in-place on their creation sequence number in O(n)
 *     and without using any extra space. For simplicity, let’s assume we are passed an integer
 *     array containing only the sequence numbers, though each number is actually an object.
 *     <p>
 * @note Solution - As we know, the input array contains numbers from the range 1 to n. We can use
 *     this fact to devise an efficient way to sort the numbers. Since all numbers are unique, we
 *     can try placing each number at its correct place, i.e., placing 1 at index ‘0’, placing 2 at
 *     index ‘1’, and so on.
 *     <p>To place a number (or an object in general) at its correct index, we first need to find
 *     that number. If we first find a number and then place it at its correct place, it will take
 *     us O(N^2), which is not acceptable.
 *     <p>Instead, what if we iterate the array one number at a time, and if the current number we
 *     are iterating is not at the correct index, we swap it with the number at its correct index.
 *     This way, we will go through all numbers and place them at their correct indices, hence,
 *     sorting the whole array.
 *     <p>
 * @note Time complexity - The time complexity of the below algorithm is O(n). Although we are not
 *     incrementing the index i when swapping the numbers, this will result in more than n
 *     iterations of the loop, but in the worst-case scenario, the while loop will swap a total of
 *     n-1 numbers, and once a number is at its correct index, we will move on to the next number by
 *     incrementing i. So overall, our algorithm will take O(n) + O(n-1) which is asymptotically
 *     equivalent to O(n).
 *     <p>
 * @note Space complexity - The algorithm runs in constant space O(1).
 * @author David Kariuki
 * @since 23/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.sorting;

public class CyclicSortEasy {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr = new int[] {3, 1, 5, 4, 2};
    CyclicSortEasy.sort(arr);
    for (int num : arr) System.out.print(num + " ");
    System.out.println();

    arr = new int[] {2, 6, 4, 3, 1, 5};
    CyclicSortEasy.sort(arr);
    for (int num : arr) System.out.print(num + " ");
    System.out.println();

    arr = new int[] {1, 5, 6, 4, 3, 2};
    CyclicSortEasy.sort(arr);
    for (int num : arr) System.out.print(num + " ");
    System.out.println();
  }

  /**
   * Method to sort int[]
   *
   * @param nums - int[]
   */
  public static void sort(int[] nums) {

    int i = 0;

    while (i < nums.length) {
      int j = nums[i] - 1;

      if (nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        i++;
      }
    }
  }

  /**
   * Methods to swap array elements
   *
   * @param arr - int[]
   * @param i - int
   * @param j - int
   */
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
