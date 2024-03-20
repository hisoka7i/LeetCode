public class sqrt {
    public static void main(String[] args) {
        
    }
    public int floorSqrt(int n){
        int ans = 1;
        int low = 1, high = n;
        while(low<=high){
            double mid = (high+low)/2;
            double val = mid * mid;
            if(val <= (double)n){
                //if this check pass then it means, that 
                low = (int)mid + 1;
            }else{
                high = (int)mid - 1;
            }
        }
        return ans;
    }
}
