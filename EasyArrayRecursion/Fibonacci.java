public class Fibonacci {
    public static void main(String[] args){
        int i = 0;
        while(i<=5){
            System.out.print(fibon(i)+" ");
            i++;
        }
    }
    static int fibon(int n){
        if(n==1 || n==0){
            return 1;
        }
        return fibon(n-2)+(fibon(n-1));
    }
}
