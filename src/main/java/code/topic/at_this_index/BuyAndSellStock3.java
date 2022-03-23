package code.topic.at_this_index;

import java.util.Arrays;

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

 */
public class BuyAndSellStock3 {

    public static void main(String[] args) {
        BuyAndSellStock3 buyAndSellStock3 = new BuyAndSellStock3();
        System.out.println(buyAndSellStock3.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    public int maxProfit(int[] prices)
    {
        int leftBuySell[] = new int[prices.length];
        int rightBuySell[] = new int[prices.length];

        int leastNumberTillHereFromLeft = prices[0];
        int maxNumberTillHereFromRight = prices[prices.length - 1];
        /*
            Calculating leftBuySell[]
            Each index represent value = what if 1 buy sell completed today or
            before today(on left side)
         */
        int maxProfitTillNow = 0;
        for (int i = 0 ; i < prices.length ; i++)
        {
            if (prices[i] < leastNumberTillHereFromLeft)
                leastNumberTillHereFromLeft = prices[i];

            maxProfitTillNow = Math.max(maxProfitTillNow, prices[i] - leastNumberTillHereFromLeft);
            leftBuySell[i] = maxProfitTillNow;
        }
        System.out.println(Arrays.toString(leftBuySell));
        /*
            calculating rightBuySell[]
            Each index represent value = what if 1 buy sell completed today or
            after today(on right side)
         */
        maxProfitTillNow = 0;
        for(int i = prices.length -1 ; i >= 0 ; i--)
        {
            if(prices[i] > maxNumberTillHereFromRight)
                maxNumberTillHereFromRight = prices[i];

            maxProfitTillNow = Math.max(maxProfitTillNow, maxNumberTillHereFromRight - prices[i]);

            rightBuySell[i] = maxProfitTillNow;
        }
        System.out.println(Arrays.toString(rightBuySell));

        /*
            calculating maxProfit
         */
        maxProfitTillNow = 0;

        for(int i = prices.length -1; i > 0 ; i--)
        {
            maxProfitTillNow = Math.max(maxProfitTillNow, leftBuySell[i-1] + rightBuySell[i]);
        }

        return Math.max(maxProfitTillNow, Math.max(leftBuySell[prices.length-1], rightBuySell[0]));
    }
}
