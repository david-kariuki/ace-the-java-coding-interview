/**
 * MaximumSumSubarrayOfSizeK Class
 *
 * <p>
 *
 * @question Problem Statement - Given an array of positive numbers and a positive number ‘k,’ find
 *     the maximum sum of any contiguous subarray of size ‘k’.
 *     <p>
 * @note Solution - If you observe closely, you will realize that to calculate the sum of a
 *     contiguous subarray, we can utilize the sum of the previous subarray. For this, consider each
 *     subarray as a Sliding Window of size ‘k.’ To calculate the sum of the next subarray, we need
 *     to slide the window ahead by one element. So to slide the window forward and calculate the
 *     sum of the new position of the sliding window, we need to do two things:
 *     <p>Subtract the element going out of the sliding window, i.e., subtract the first element of
 *     the window.
 *     <p>Add the new element getting included in the sliding window, i.e ., the element coming
 *     right after the end of the window. This approach will save us from re-calculating the sum of
 *     the overlapping part of the sliding window.
 *     <p>
 * @note Time Complexity - The time complexity of the above algorithm will be O(N) .
 * @note Space Complexity - The algorithm runs in constant space O(1).
 * @author David Kariuki
 * @since 23/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

public class MaximumSumSubarrayOfSizeK {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    System.out.println(
        "Maximum sum of a subarray of size K: "
            + findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
    System.out.println(
        "Maximum sum of a subarray of size K: " + findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5}));
  }

  /** Method to find max sum sub array */
  public static int findMaxSumSubArray(int k, int[] arr) {

    int windowSum = 0;
    int maxSum = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

      windowSum += arr[windowEnd]; // Add the next element

      // Slide the window, we don't need to slide if we've no hit the
      // required window size of k
      if (windowEnd >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowStart]; // subtract the element going out
        windowStart++; // slide the window ahead
      }
    }

    return maxSum;
  }
}
