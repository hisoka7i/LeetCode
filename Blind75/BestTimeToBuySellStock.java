public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int l = 0;
        int r = 1;
        int n = prices.length;
        int max = 0;
        while(r<n){
            int left = prices[l];
            int right = prices[r];
            if(right <= left){
                l = r;
            }else{
                max = Math.max((right-left),max);
            }
            r++;
        }
        return max;
    }
}
