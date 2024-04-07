public class EuclidsAlgoGCD {
    public static void main(String[] args){
        int value = gcd(3,12);
        System.out.println(value);
    }
    static int gcd(int a, int b){
        //base condition
        if(a==0)return b;
        return gcd(b%a,a);
    }
}
