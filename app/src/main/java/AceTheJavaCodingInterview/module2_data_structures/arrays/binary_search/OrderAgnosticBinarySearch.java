/**
 * OrderAgnosticBinarySearch Class
 *
 * <p>
 *
 * @question Problem Statement - Given a sorted array of numbers, find if a given number ‘key’ is
 *     present in the array. Though we know that the array is sorted, we don’t know if it’s sorted
 *     in ascending or descending order. You should assume that the array can have duplicates.
 *     <p>Write a function to return the index of the ‘key’ if it is present in the array, otherwise
 *     return -1.
 * @note Solution - To make things simple, let’s first solve this problem assuming that the input
 *     array is sorted in ascending order. Here are the set of steps for Binary Search:
 *     <p>Let’s assume start is pointing to the first index and end is pointing to the last index of
 *     the input array (let’s call it arr).
 *     <p>This means: int start = 0; int end = arr.length - 1;
 *     <p>First, we will find the middle. middle = start + ((end - start) / 2)
 *     <p>Next, we will see if the ‘key’ is equal to the number at index middle. If it is equal we
 *     return middle as the required index. If ‘key’ is not equal to number at index middle, we have
 *     to check two things:
 *     <p>If (key < arr[middle]), then we can conclude that the key will be smaller than all the
 *     numbers after index middle as the array is sorted in the ascending order. Hence, we can
 *     reduce our search to end = mid - 1.
 *     <p>If (key > arr[middle]), then we can conclude that the key will be greater than all numbers
 *     before index middle as the array is sorted in the ascending order. Hence, we can reduce our
 *     search to start = mid + 1.
 *     <p>We will repeat steps 2-4 with new ranges of start to end. If at any time start becomes
 *     greater than end, this means that we can’t find the ‘key’ in the input array and we must
 *     return ‘-1’.
 *     <p>
 *     <p>If the array is sorted in the descending order, we have to update the step 4 above as:
 *     <p>If key > arr[middle], then we can conclude that the key will be greater than all numbers
 *     after index middle as the array is sorted in the descending order. Hence, we can reduce our
 *     search to end = mid - 1.
 *     <p>If key < arr[middle], then we can conclude that the key will be smaller than all the
 *     numbers before index middle as the array is sorted in the descending order. Hence, we can
 *     reduce our search to start = mid + 1.
 *     <p>Finally, how can we figure out the sort order of the input array? We can compare the
 *     numbers pointed out by start and end index to find the sort order. If arr[start] < arr[end],
 *     it means that the numbers are sorted in ascending order otherwise they are sorted in the
 *     descending order.
 *     <p>
 * @note Time complexity - Since, we are reducing the search range by half at every step, this means
 *     that the time complexity of our algorithm will be O(logN) where N is the total elements in
 *     the given array.
 *     <p>
 * @note Space complexity - The algorithm runs in constant space O(1).
 * @author David Kariuki
 * @since 24/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.binary_search;

public class OrderAgnosticBinarySearch {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    System.out.println(OrderAgnosticBinarySearch.search(new int[] {4, 6, 10}, 10));
    System.out.println(OrderAgnosticBinarySearch.search(new int[] {1, 2, 3, 4, 5, 6, 7}, 5));
    System.out.println(OrderAgnosticBinarySearch.search(new int[] {10, 6, 4}, 10));
    System.out.println(OrderAgnosticBinarySearch.search(new int[] {10, 6, 4}, 4));
  }

  /** Method to search array and return index of key */
  public static int search(int[] nums, int key) {

    int start = 0; // Initialize start
    int end = nums.length - 1; // Initialize end

    // Check if array is ascending or descending
    boolean arrayIsAscending = nums[start] < nums[end];

    // Traverse array
    while (start <= end) {

      int mid = start + ((end - start) / 2);

      // Check if key is at the midpoint
      if (nums[mid] == key) {
        return mid;
      }

      if (arrayIsAscending) { // ascending order

        if (nums[mid] > key) {
          end = mid - 1; // The key can be in the first half
        } else if (nums[mid] < key) {
          start = mid + 1; // The key can be in the second half
        }

      } else { // Descending order
        if (nums[mid] > key) {
          start = mid + 1;
        } else if (nums[mid] < key) {
          end = mid - 1;
        }
      }
    }

    return -1;
  }
}
