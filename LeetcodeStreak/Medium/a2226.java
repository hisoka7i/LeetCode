package LeetcodeStreak.Medium;

public class a2226 {
    public int maximumCandies(int[] candies, long k) {
        int maxValue = Integer.MIN_VALUE;
        for(int candy: candies){
            maxValue = Math.max(candy, maxValue);
        }
        int l = 0;
        int r = maxValue;
        int result = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(maxRec(candies, mid) >= k){
                result = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return result;
    }
    public long maxRec(int[] candies, int mid){
        long receivers = 0;
        for(int candy: candies){
            receivers += Math.floor((double)candy/(double)mid);
        }
        return  receivers;
    }
}
