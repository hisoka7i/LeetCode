public class NthRoot {
    public static void main(String[] args) {
        
    }
    //This function will do the multiply job
    public int multiplyJob(int n,int m,int mid){
        long ans = 1;
        for(int i=1;i<=n;i++){
            ans = ans * mid; //we are multiplying the same number again and again n times
            if(ans>m)return 2;
            //If 2 is returned that means that we need to remove the right half
        }
        if(ans == m)return 1;
        return 0;
    }
    //This function will do the binary search
    public int binarySearch(int n,int m){
        int low = 1, high = n;
        while(low<=high){
            int mid = low + (high-low)/2;
            int midN = multiplyJob(n, m, mid);
            if(midN==1)return mid;
            else if(midN==2){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
