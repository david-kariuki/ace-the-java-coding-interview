/**
 * Tuple Class
 *
 * <p>
 *
 * @implNote Creating a tuple class as java does not support returning multiple arguments
 * @author David Kariuki
 * @since 18/8/2022
 */
package AceTheJavaCodingInterview.data_structures.tuple;

public class Tuple<X, Y> {

  public X x;
  public Y y;

  /**
   * Class constructor
   *
   * @param x - X
   * @param y - Y
   */
  public Tuple(X x, Y y) {
    this.x = x;
    this.y = y;
  }
}
