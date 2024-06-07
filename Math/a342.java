package Math;

public class a342 {
    public static void main(String[] args) {
        //Power of Four
    }
    public static boolean isPowerOfFour(int n) {
        if(n==1)return true;
        if(n <= 0) return false;
        while(n>1 && (n%4)==0){
            n = n/4;
        }
        if(n==1)return true;
        return (n%4==0);
    }
}
