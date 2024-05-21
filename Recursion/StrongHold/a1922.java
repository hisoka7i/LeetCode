package StrongHold;

import javax.jws.WebParam.Mode;

public class a1922 {
    private static long MOD = 1_000_000_007;
    public static void main(String[] args) {
        
    }
    public static int countGoodNumbers(long n) {
        //we will use concept of permutation and combination
        //for even places only 5 numbers are allowed 0,2,4,6,8
        //for odd places only 4 numbers are allowed 2,3,5,7

        //number of even places will be n+1 / 2 and number of odd places will be n/2
        //so number of possible solutions will be 
        //5^(even_places)  * 4^(odd_places)

        long even = (n+1)/2;
        long odd = n/2;

        long first = pow(5,even);
        long second = pow(4,odd);

        return (int)((first*second)%MOD);
    }
    public static long pow(long x, long n){
        if(n==0)return 1;

        long temp = pow(x,n/2);

        if(n%2==0){
            return (temp*temp)%MOD;
        }else{
            return (x*temp*temp)%MOD;
        }
    }
}
