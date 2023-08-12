import java.util.Scanner;

public class NewtonRapsonMethod {
    public static void main(String[] args){
        System.out.println("Enter the number that you want the square root of:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        newton(number);
    }
    public static void newton(int n){
        double x = n;
        double root;
        while(true){
            root = 0.5*(x+(n/x));
            if(Math.abs(x-root)<0.5){
                System.out.println("Square root of the number is:"+root);
                break;
            }
            x=root;
        }
    }
}
