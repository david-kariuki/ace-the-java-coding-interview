/**
 * CH4_ArrayOFProductsOfAllElementsExceptItself Class
 *
 * <p>
 *
 * @note Given an array, return an array where each index stores the product of all numbers except
 *     the number on the index itself.
 * @author David Kariuki
 * @since 16/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.challenges;

import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

public class CH4_ArrayOFProductsOfAllElementsExceptItself {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[] arr = {-1, 2, -3, 4, -5};

    System.out.println("Array before product: " + DataStructuresUtils.arrayToString(arr));

    int[] prodArray = findProduct(arr);

    System.out.println("Array after product: " + DataStructuresUtils.arrayToString(prodArray));
  }

  /**
   * Find product
   *
   * <p>Time complexity is O(n) Space complexity is O(n) Auxiliary Space Used is O(1)
   *
   * @param arr - int[]
   */
  public static int[] findProduct(int[] arr) {

    int n = arr.length;
    int i, temp = 1;

    // Allocation of result array
    int[] result = new int[n];

    // Product of elements on left side excluding arr[i]
    for (i = 0; i < n; i++) {
      System.out.println(
          "1.---  i : "
              + i
              + " temp : "
              + temp
              + " arr[i] :"
              + " "
              + arr[i]
              + " result[i] : "
              + result[i]);
      result[i] = temp;
      temp *= arr[i];
    }

    System.out.println("\n");

    // Initializing temp to 1 for product on right side
    temp = 1;

    // Product of elements on right side excluding arr[i]
    for (i = n - 1; i >= 0; i--) {
      System.out.println(
          "2.---  i : "
              + i
              + " temp : "
              + temp
              + " arr[i] :"
              + " "
              + arr[i]
              + " result[i] : "
              + result[i]);
      result[i] *= temp;
      temp *= arr[i];
    }

    return result;
  }
}
