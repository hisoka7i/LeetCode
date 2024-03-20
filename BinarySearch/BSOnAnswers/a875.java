import java.util.Arrays;

public class a875 {
    public static void main(String[] args) {
        int[] sample = {3,6,7,11};
        System.out.println(minEatingSpeed(sample, 8));
    }
    //This is basic implementation of lower bound code
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 0, high = piles[piles.length-1];
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(findValidK(piles, high, mid)<=h) {
                System.out.println("working");
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int findValidK(int[] piles, int h, int mid){
        int countHrs  = 0;
        for(int i=0;i<piles.length;i++){
            //we are making it double to get the exact answerr
            countHrs += Math.ceil((double)piles[i]/(double)mid);
        }
        return countHrs;
    }
}
