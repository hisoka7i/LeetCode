package StrongHold;

public class a50 {
    public static void main(String[] args) {
        
    }
    public static double myPow(double x, int n) {
        double ans = 1;
        //changed from int to long to avoid spill
        long nn = n;
        if(nn<0)nn = -1 * nn;
        while(nn>0){
            if(nn%2==1){
                //we are multiplying x only one time in case of single occurance
                ans = ans * x;
                //now we will decrease the power only by one
                nn = nn -1;
            }else{
                x = x * x;
                //now we will decrease the nn by half 
                nn = nn/2;
            }
        }
        //in case n is less than 1 
        if(n<0)ans = (double)1.0/(double)ans;
        return ans;
    }
}
