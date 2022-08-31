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
import java.util.Arrays;

@SuppressWarnings("StringConcatenationInLoop")
public class MergeAnArrayWithOverlappingIntervals {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    Interval[] v1 = {new Interval(1, 5), new Interval(3, 7), new Interval(4, 6)};

    Interval[] v2 = {
      new Interval(1, 5), new Interval(4, 6), new Interval(6, 8), new Interval(11, 15)
    };

    Interval[] v3 = {
      new Interval(3, 7), new Interval(6, 8), new Interval(10, 12), new Interval(11, 15)
    };

    Interval[] v4 = {new Interval(1, 5)};

    Interval[][] vList = {v1, v2, v3, v4};

    for (int i = 0; i < vList.length; i++) {

      ArrayList<Interval> v = new ArrayList<>(Arrays.asList(vList[i]));
      System.out.print(i + 1);
      printIntervalList(v);

      ArrayList<Interval> result = mergeIntervals(v);
      String result_str = "";

      for (int j = 0; j < result.size(); j++) {
        result_str += "[" + result.get(j).first + ", " + result.get(j).second + "] ";
      }

      System.out.println("   Merged intervals:\t" + result_str);
      System.out.println("------------------------------\n");
    }
  }

  /**
   * Method to merge intervals
   *
   * @note Time complexity - The time complexity of this solution is linear, O(n).
   * @note Space complexity - The space complexity of this solution is linear, O(n).
   * @param arrayList - ArrayList<Interval>
   * @return ArrayList<Interval>
   */
  public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> arrayList) {

    // If the list is empty
    if (arrayList == null || arrayList.size() == 0) {
      return null;
    }

    ArrayList<Interval> result = new ArrayList<>();

    // Adding interval in the result list
    result.add(new Interval(arrayList.get(0).first, arrayList.get(0).second));

    for (int i = 1; i < arrayList.size(); i++) {

      // Getting the recent added interval in the result list
      Interval recentAddedInterval = result.get(result.size() - 1);

      // Getting and initializing input interval
      int currentStart = arrayList.get(i).first;
      int currentEnd = arrayList.get(i).second;

      // Getting and initializing previous end recently added interval from
      // result list
      int previousEnd = recentAddedInterval.second;

      // Overlapping condition
      if (previousEnd >= currentStart) {
        recentAddedInterval.second = Math.max(currentEnd, previousEnd);
      }

      // No overlapping
      else {
        result.add(new Interval(currentStart, currentEnd));
      }
    }

    return result;
  }

  /**
   * Method to print the list of intervals
   *
   * @param list - ArrayList<Interval>
   */
  public static void printIntervalList(ArrayList<Interval> list) {

    String resultStr = "";

    for (int i = 0; i < list.size(); i++) {

      Interval p = list.get(i);

      resultStr += "[" + p.first + ", " + p.second + "]";

      if (i != list.size() - 1) {
        resultStr += ",";
      }
    }

    System.out.println(". Intervals to merge:\t" + resultStr);
  }
}
