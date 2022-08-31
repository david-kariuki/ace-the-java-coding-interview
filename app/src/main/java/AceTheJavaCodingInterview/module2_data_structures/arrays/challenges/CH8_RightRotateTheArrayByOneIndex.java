/**
 * CH8_RightRotateTheArrayByOneIndex Class
 *
 * <p>
 *
 * @note Given an array, can you rotate its elements once from right to left?
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

public class CH8_RightRotateTheArrayByOneIndex {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {
    int[] arr = {3, 6, 1, 8, 4, 2};

    System.out.print("Array before rotation: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    rotateArray(arr);

    System.out.print("Array after rotation: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  /**
   * Method to rotate an int array
   *
   * <p>
   *
   * @note Time Complexity# Since the entire array is iterated over once, the time complexity of
   *     this solution is O(n).
   * @param arr - int[]
   */
  @SuppressWarnings("ManualArrayCopy")
  public static void rotateArray(int[] arr) {

    int lastElement = arr[arr.length - 1]; // get last element

    for (int i = arr.length - 1; i > 0; i--) {
      arr[i] = arr[i - 1];
    }

    arr[0] = lastElement;
  }
}
