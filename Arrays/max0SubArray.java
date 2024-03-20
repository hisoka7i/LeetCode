import java.util.HashMap;

public class max0SubArray {
    public static void main(String[] args) {
        int[] sample ={1,-1,3,2,-2,-8,1,7,10,23};
        System.out.println(maxLen(sample, sample.length));
    }
    
    public static int maxLen(int A[], int n)
    {
        //We are maintaining a prefix as key, and first index as value
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0; 

        for(int i = 0;i<n;i++) {
            sum += A[i]; 
            if(sum == 0) {
                maxi = i + 1; 
            }
            else {
                if(mpp.get(sum) != null) {
                    //please look at the image file in git repo to understand this.
                    maxi = Math.max(maxi, i - mpp.get(sum)); 
                }
                else {
                    mpp.put(sum, i); 
                }
            }
        }
        return maxi; 
    }
}
