/**
 * CH2_MergeTwoSortedArrays Class
 *
 * <p>
 *
 * @note Challenge 2: Merge Two Sorted Arrays
 * Given two sorted arrays, merge them into one array, which should also
 * be sorted.
 * @author David Kariuki
 * @since 14/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

public class CH2_MergeTwoSortedArrays {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr1 = {1, 12, 14, 17, 23};
    int[] arr2 = {11, 19, 27};

    int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays

    System.out.print("Arrays after merging: ");
    for (int i = 0; i < arr1.length + arr2.length; i++) {
      System.out.print(resultantArray[i] + " ");
    }
  }

  /**
   * Method to remove even numbers from array
   *
   * <p>The time complexity for this algorithm is O(n+m), where n and m are the * sizes of arr1 and
   * arr2, respectively. This is because both arrays are iterated over once.
   *
   * @param arr1 - Array1
   * @param arr2 - Array2
   */
  public static int[] mergeArrays(int[] arr1, int[] arr2) {

    int arr1Length = arr1.length;
    int arr2Length = arr2.length;

    int[] mergedArray = new int[(arr1Length + arr2Length)];

    int i = 0, j = 0, k = 0;

    // Traverse both arrays
    while (i < arr1Length && j < arr2Length) {

      // Check if current element of first array is smaller than current
      // element of second array. If yes, store first array element and
      // increment first array index. Otherwise, do same with second array
      if (arr1[i] < arr2[j]) {
        mergedArray[k++] = arr1[i++]; // Add element from array 1
      } else if (arr2[j] < arr1[i]) {
        mergedArray[k++] = arr2[j++]; // Add element from array 2
      }
    }

    // Store the remaining elements of 1st array
    while (i < arr1Length) {
      mergedArray[k++] = arr1[i++];
    }

    // Store the remaining elements of 2nd array
    while (j < arr2Length) {
      mergedArray[k++] = arr2[j++];
    }

    return mergedArray;
  }
}
