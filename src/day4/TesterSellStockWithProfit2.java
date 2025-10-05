package day4;

public class TesterSellStockWithProfit2 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        Integer stock = null;

        for (int pos = 0; pos < prices.length - 1; pos++) {
            // if pos+1 is getting high give curret to stock and stock should not be zero already,
            //if pos+1 is getting low make stock as zero, profit=stock-prices[pos]
            if (prices[pos] <= prices[pos + 1]) {
                if (stock == null) {
                    stock = prices[pos];
                }
            } else {
                if (stock != null) {
                    profit = profit + (prices[pos] - stock);
                    stock = null;
                }
            }
        }
        if (stock != null) {
            profit = profit + (prices[prices.length-1] - stock);
            stock = null;
        }
        return profit;
    }


    public static void main(String[] args) {
        //Test case1
        int[] stocks = {7, 1, 5, 3, 6, 4};
        //System.out.println("Max Profit:" +new TesterSellStockWithProfit2().maxProfit(stocks));
        //Test case2
       // stocks = new int[]{1, 2, 3, 4, 5};
        //System.out.println("Max Profit:" + new TesterSellStockWithProfit2().maxProfit(stocks));

        //stocks= new int[]{7,6,4,3,1};
        //System.out.println("Max Profit:" +new TesterSellStockWithProfit2().maxProfit(stocks));

        stocks=new int[]{2,1,2,0,1};
        System.out.println("Max Profit:" + new TesterSellStockWithProfit2().maxProfit(stocks));


    }
}

//multiple time buy cell and profit agrregate
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/