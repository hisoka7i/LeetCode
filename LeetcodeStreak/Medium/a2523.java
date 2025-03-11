package LeetcodeStreak.Medium;

public class a2523 {
    public static void main(String[] args) {
        System.out.println(isPrime(11));  // true
        System.out.println(isPrime(25));  // false
        System.out.println(isPrime(29));   // true
        System.out.println(isPrime(97));  // true
    }
    // int lowest = 0;
    public int[] closestPrimes(int left, int right) {
        int n1 = findFloor(left, right); 
        if(n1 == -1){
            return new int[]{-1,-1};
        }
        int n2 = findFloor(n1+1, right);
        if(n2 == -1){
            return new int[]{-1,-1};
        }
        return new int[]{n1,n2};
    }
    public int findFloor(int left, int right){
        if(left > right )return -1;

        int mid = (right-left)/2 + left;

        if(isPrime(mid))return mid;

        int leftresult = findFloor(left, mid - 1);
        if(leftresult != -1) return leftresult; 

        return findFloor(mid+1, right);
    }
    public static boolean isPrime(int n){
        if (n <= 1) return false;  // 0,1 are not prime
        if (n == 2 || n == 3) return true;  // 2,3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false; // Eliminate even numbers & multiples of 3
        
        for (int i = 5; i * i <= n; i += 6) { // Check from 5 to √N (skipping even numbers)
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
