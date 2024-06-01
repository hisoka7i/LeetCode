package ArrayQuestions;
public class a121 {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;
        while(r<=prices.length){
            int profit = prices[r]-prices[l];
            if(profit>0){
                maxProfit = Math.max(maxProfit, profit);
            }else{
                l=r;
            }
            r++;
        }
        return maxProfit;
    }
}
