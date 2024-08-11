package Others;
import java.util.Scanner;
//import java.util.*;
import java.util.Arrays;
public class StieveOfEratosthenes {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number:");
        int number = scan.nextInt();
        boolean[] bool = new boolean[number+1];
        Arrays.fill(bool, false);
        sieve(number, bool);
        printPrimes(bool);
    }
    public static void sieve(int number, boolean[] bool){
        
        for(int i=2;i*i<=number;i++){
            if(!bool[i]){
                //here only the first occurance of a number will enter. 
                //So naturally they will be prime
                for(int n=i*2; n<=number; n+=i){
                    bool[n]=Boolean.TRUE;      
            }
        }
    }
    }
    public static void printPrimes(boolean[] bool){
        int count=0;
        for(int i=2;i<bool.length;i++){
            if(!bool[i]){
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
