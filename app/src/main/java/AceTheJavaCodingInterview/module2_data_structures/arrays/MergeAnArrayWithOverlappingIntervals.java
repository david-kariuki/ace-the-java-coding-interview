/**
 * MergeAnArrayWithOverlappingIntervals Class
 *
 * <p>
 *
 * @question We’re given an array of interval pairs as input where each interval has a start and end
 *     timestamp. The input array is sorted by starting timestamps. Merge the overlapping intervals
 *     and return a new output array.
 *     <p>
 * @note Solution - This problem can be solved in a simple linear scan algorithm. We know that the
 *     input is sorted by starting timestamps. Here is the approach we are following:
 *     <p>Using the given list of input intervals, we keep merged intervals in the output list.
 *     <p>For each interval in the input list: If the input interval is overlapping with the last
 *     interval in the output list, then we merge these two intervals and update the last interval
 *     of the output list with the merged interval.
 *     <p>Otherwise, we add an input interval to the output list.
 * @author David Kariuki
 * @since 22/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

import AceTheJavaCodingInterview.module2_data_structures.tuples.Interval;

import java.util.ArrayList;

public class MergeAnArrayWithOverlappingIntervals {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {}

  private static ArrayList<Interval> mergeIntervals(ArrayList<Interval> arrayList) {

    // If the list is empty
    if (v == null || v.size() == 0) {
      return null;
    }
  }
}
