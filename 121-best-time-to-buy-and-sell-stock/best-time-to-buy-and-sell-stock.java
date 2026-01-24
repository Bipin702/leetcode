class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minNumber = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if(price < minNumber){
                minNumber = price;
            }else if(price - minNumber > maxProfit){
                maxProfit = price - minNumber;
            }
        }
        return maxProfit;
    }
}