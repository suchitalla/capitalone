package org.practice.stocks;
//Leet - 121
public class BestTimeBSStock {

    //O(n^2)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int supermax =0;

        for(int i=0;i<len;i++){
            int buy = prices[i];
            int currmax =0;
            for(int j=i+1;j<len;j++){
                int maxdiff = prices[j] - buy;
                currmax = Math.max(currmax,maxdiff);
            }
            supermax = Math.max(supermax,currmax);
        }

        return supermax;
    }

    public int maxProfitV2(int[] prices) {
        int len = prices.length;
        int minprice = Integer.MAX_VALUE;
        int supermax =0;

        for(int p : prices){
            if(p < minprice){
                minprice = p;
            } else if((p-minprice) > supermax){
                supermax = p-minprice;
            }
        }

        return supermax;
    }
}
