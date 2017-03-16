/**
 * Created by test on 2/13/17.
 */

// Number 121

public class BuySellStock {

    public int maxProfit(int[] prices) {

        if(prices.length == 0 || prices.length == 1){
            return 0;
        }

        int minBuyPrice = prices[0];

        // the maximum profit that is possible to make before time i
        int maxProfitSoFar = 0;

        for(int i = 1; i < prices.length; i++){

            // if the price at time i gives a better profit
            // then the current max profit, then we update the max profit
            if(prices[i] - minBuyPrice > 0){
                maxProfitSoFar += prices[i] - minBuyPrice;
            }

            // if the price at time i is now the minimum
            // over all time from 0 to time i, then we update the minimum price
            minBuyPrice = prices[i];

        }

        return maxProfitSoFar;

    }


}
