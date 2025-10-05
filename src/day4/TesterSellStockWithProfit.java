package day4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TesterSellStockWithProfit {

    public int maxProfit(int[] prices) {
        int maxVal=prices[0]; int minVal=prices[0];
        int maxProfit=Integer.MIN_VALUE;
        for(int pos=0; pos<prices.length;pos++){
            if(maxVal<prices[pos]){
                maxVal=prices[pos];
            }
            if(minVal>prices[pos]){
                minVal=prices[pos];
                maxVal=prices[pos];
            }
            maxProfit= Math.max(maxVal-minVal,maxProfit);
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        //Test case1
        int[] stocks={7,1,5,3,6,4};
        System.out.println("Max Profit:" +new TesterSellStockWithProfit().maxProfit(stocks));
        //Test case2
        stocks=new int[]{7,6,4,3,1};
        System.out.println("Max Profit:" +new TesterSellStockWithProfit().maxProfit(stocks));

        stocks= new int[]{3,2,6,5,0,3};
        System.out.println("Max Profit:" +new TesterSellStockWithProfit().maxProfit(stocks));

    }
}
// one time biy cell for maximum
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/