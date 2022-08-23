/**
 * Interval Tuple Class
 *
 * <p>
 *
 * @implNote Creating a tuple class as java does not support returning multiple arguments
 * @author David Kariuki
 * @since 22/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.tuples;

public class Interval {

  public int first;
  public int second;

  /**
   * Class constructor
   *
   * @param x - X
   * @param y - Y
   */
  public Interval(int x, int y) {
    this.first = x;
    this.second = y;
  }
}
