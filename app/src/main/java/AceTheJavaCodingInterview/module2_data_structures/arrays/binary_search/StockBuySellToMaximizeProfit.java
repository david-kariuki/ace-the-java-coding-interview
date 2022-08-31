/**
 * StockBuySellToMaximizeProfit Class
 *
 * <p>
 *
 * @question Given a list of stock prices, find the maximum profit with a single buy or sell
 *     activity.
 *     <p>We’re given an array of daily stock prices (integers for simplicity). Return the buying
 *     and selling prices for making the maximum profit.
 *     <p>The values in the array represent the cost of stock each day. As we can buy and sell the
 *     stock only once, we need to find the best buy and sell prices that maximize profit (or
 *     minimized loss) over a given span of time.
 *     <p>We need to maximize the profit from a single buy and sell. If we can’t make any profit,
 *     we’ll try to minimize the loss.
 * @author David Kariuki
 * @since 18/8/2022
 */
package AceTheJavaCodingInterview.module2_data_structures.arrays.binary_search;

import AceTheJavaCodingInterview.module2_data_structures.tuples.Tuple;
import AceTheJavaCodingInterview.module2_data_structures.utils.DataStructuresUtils;

@SuppressWarnings("UnusedAssignment")
public class StockBuySellToMaximizeProfit {

  /**
   * Main method
   *
   * @param args - String[]
   */
  public static void main(String[] args) {

    int[][] stockNums = {
      {1, 2, 3, 4, 3, 2, 1, 2, 5}, {8, 6, 5, 4, 3, 2, 1}, {12, 30, 40, 90, 110}, {2}
    };

    for (int i = 0; i < stockNums.length; i++) {
      Tuple<Integer, Integer> result = findBuySellStockPrices(stockNums[i]);
      System.out.println(
          (i + 1) + ". Day stocks: " + DataStructuresUtils.arrayToString(stockNums[i]));
      if (result != null) {
        System.out.println("   Buy Price: " + result.x + ", Sell Price: " + result.y);
      } else {
        System.out.println("   Buy Price: null, Sell Price: null");
      }
      System.out.println("----------------------------\n");
    }
  }

  /**
   * Method to find buy and sell stock prices
   *
   * <p>
   *
   * @note Time complexity - The time complexity of this solution is O(n).
   * @note Space complexity - The space complexity of this algorithm is O(1).
   */
  @SuppressWarnings("Convert2Diamond")
  public static Tuple<Integer, Integer> findBuySellStockPrices(int[] stockNums) {
    // Return None when stock list is empty or less than 2
    if (stockNums == null || stockNums.length < 2) {
      return null;
    }

    // Initializations
    int current_buy = stockNums[0];
    int global_sell = stockNums[1];

    // Calculating the global profit
    int global_profit = global_sell - current_buy;

    // Initializing current_profit with minimum value
    int current_profit = Integer.MIN_VALUE;

    // Looping over stocks to find best buy and selling price
    for (int i = 1; i < stockNums.length; i++) {
      // Calculating the current profit
      current_profit = stockNums[i] - current_buy;

      // Current profit is greater than the global profit
      if (current_profit > global_profit) {
        global_profit = current_profit;
        global_sell = stockNums[i];
      }

      // We will always maximise margin relative to the lowest stock price we can find
      // So whenever we find a stock price lower than the current buying price,
      // we adopt it as the current buying price
      if (current_buy > stockNums[i]) {
        current_buy = stockNums[i];
      }
    }

    // Tuple having buy price and sell price
    return new Tuple<Integer, Integer>(global_sell - global_profit, global_sell);
  }
}
