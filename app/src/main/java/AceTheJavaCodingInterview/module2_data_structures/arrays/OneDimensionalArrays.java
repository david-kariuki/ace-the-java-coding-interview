/**
 * OneDimensionalArrays Class
 *
 * <p>
 *
 * @note
 * @author David Kariuki
 * @since 14/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays;

@SuppressWarnings({"ForLoopReplaceableByForEach", "SameParameterValue"})
public class OneDimensionalArrays {

  public static final int[] myArray = new int[4]; // Array declaration

  public static void main(String[] args) {

    initArray(); // Array initialization
    showArrayElements();
    updateArrayElement(2, 50);
    showArrayElements();
  }

  /**
   * Method to initialize array
   */
  public static void initArray() {

    // Adding elements in an array
    myArray[0] = 10;
    myArray[1] = 20;
    myArray[2] = 30;
    myArray[3] = 40;
  }

  /**
   * Method to update array element
   *
   */
  public static void updateArrayElement(final int index, final int value) {
      myArray[index] = value;
  }

  /** Method to show array elements */
  public static void showArrayElements() {

    System.out.println("\nPrinting array elements\n");

    // Accessing elements in an array
    for (int i = 0; i < myArray.length; i++) {
      System.out.println(myArray[i]);
    }
  }
}
