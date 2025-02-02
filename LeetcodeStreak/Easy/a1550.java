package LeetcodeStreak.Easy;

public class a1550 {
    //Given an integer array arr, return true if there 
    //are three consecutive odd numbers in the array. Otherwise, return false.
    public static void main(String[] args) {
        
    }
    public static boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        int l = 0, r = 2;
        while(r<arr.length){
            if(arr[l]%2==1 && arr[r]%2==1){
                if(arr[l+1]%2==1)
                    return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
