import java.util.Arrays;

public class a1482 {
    public static int minDays(int[] arr, int m, int k) {
        long val = (long) m * k;
        int n = arr.length;
        if(val>n)return -1;
        //Finding minimum and maximum 
        int mini = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE;
        for(Integer currentNumber :arr){
            mini = Math.min(mini, currentNumber);
            max = Math.max(max, currentNumber);
        }
        // Apply binary search:
        int low = mini, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static boolean possible(int[] arr, int day, int m, int k){
        int count = 0;
        int bag = 0;
        for(Integer i: arr){
            if(i<=day){
                count++;
            }else{
                bag += (count/k);
                count = 0;
            }
        }
        bag += (count/k);
        return bag>=m;
    }
}
