/**
 * Class with shared data structures utils
 *
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.utils;

public class DataStructuresUtils {

  /**
   * Method to convert array to string
   *
   * @param arr - int[]
   */
  @SuppressWarnings("StringConcatenationInLoop")
  public static String arrayToString(final int[] arr) {
    if (arr.length > 0) {
      String result = "[";
      for (int i = 0; i < arr.length; i++) {
        if (i != arr.length - 1) {
          result += arr[i] + ", ";
        } else {
          result += arr[i];
        }
      }
      return result + "]";
    } else {
      return "Empty Array!";
    }
  }

  /**
   * Method to print out array elements
   *
   * @param arr - int[]
   */
  public static void printOutArray(final int[] arr) {
    System.out.println(arrayToString(arr) + "\n");
  }

  /**
   * Method to print out array elements
   *
   * @param arr - int[]
   */
  public static void printOutArray(final int[] arr, final String message) {
    System.out.println(message + arrayToString(arr) + "\n");
  }
}
