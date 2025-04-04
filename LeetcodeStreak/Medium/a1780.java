public class a1780 {
    public static void main(String[] args) {
        
    }
    public boolean checkPowersOfThree(int n) {
        return checkIfTrue(0, n);
    }

    //using recursion
    public boolean checkIfTrue(int power, int n){
        if(n==0)return true; //this means it is possible

        //this is exit condition
        if(Math.pow(3, power) > n)return false; //this means overflow
        
        //now implementing picking and not picking approach
        boolean picking = checkIfTrue(power+1, n - (int)Math.pow(3, power));

        //not picking
        boolean notpicking = checkIfTrue(power+1, n);

        return picking || notpicking;
    }
}
