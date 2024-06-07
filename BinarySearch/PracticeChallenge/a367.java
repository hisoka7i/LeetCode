package BinarySearch.PracticeChallenge;

public class a367 {
    public static void main(String[] args) {
        
    }

    //valid perfect square
    public static boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;

        while(low<=high){
            long mid = low + (high-low)/2;
            if(mid*mid == (long)num){
                return true;
            }
            if(mid*mid > (long)num){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
