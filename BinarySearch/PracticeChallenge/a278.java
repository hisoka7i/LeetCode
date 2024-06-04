package BinarySearch.PracticeChallenge;

public class a278 {
    public int firstBadVersion(int n) {
        int first = 0;
        int low = 0;
        int high = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isBadVersion(mid)){
                first = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return first;
    }
    public boolean isBadVersion(int n){
        return true;
    }
}
