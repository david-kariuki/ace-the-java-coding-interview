/**
 * TwoDimensionalArrays Class
 *
 * <p>
 *
 * @note 2D Arrays
 * @author David Kariuki
 * @since 14/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

@SuppressWarnings("SameParameterValue")
public class TwoDimensionalArrays {

  static int[][] twoDArray;

  public static void main(String[] args) {

    twoDArray = create2DArray(3, 4); // Create 2D array

    init2DArray(0, 1, 10); // Adding 10 at Row 0 Column 1
  }

  /**
   * Method to create 2D array
   *
   * @param rows - int
   * @param columns - int
   */
  public static int[][] create2DArray(int rows, int columns) {

    return new int[rows][columns]; // Create array
  }

  public static void init2DArray(int row, int column, int value) {
    twoDArray[row][column] = value;
  }
}
