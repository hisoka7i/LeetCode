package NeetcodeDSASheet.BinarySearch;

import java.util.Arrays;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 0;
        int r = piles[n-1];
        int result = 0;
        Arrays.sort(piles);
        while(l<=r){
            int m = l + (r-l)/2;
            if(countHrs(piles, m) <= h){
                result = m;
                h = m-1;
            }else{
                r = m + 1;
            }
        }
        return  result;
    }
    public int countHrs(int[] piles, int mid){
        int hrs = 0;
        for(int p: piles){
            hrs += Math.ceil((double)p/(double)mid);
        }
        return hrs;
    }
}
