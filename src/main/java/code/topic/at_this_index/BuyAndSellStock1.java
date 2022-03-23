package code.topic.at_this_index;

/*
Can buy and sell only once
Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
*/
/*
    7 , 1 , 5 , 3 , 6 , 4
        i           j
 think at j, maxProfit will be
    a[j] - (lowest number before this index)
*/
public class BuyAndSellStock1 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int leastNumberSoFar = prices[0];
        for(int i = 1 ; i < prices.length; i++)
        {
            if(prices[i] < leastNumberSoFar)
                leastNumberSoFar = prices[i];

            maxProfit = Math.max(maxProfit, prices[i] - leastNumberSoFar);
        }
        return maxProfit;
    }

}
