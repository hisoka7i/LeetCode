import java.util.*;
public class EvenOdd {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your number here: ");

        try{ 
            int number = scan.nextInt();
            if((number&1)==0){
                System.out.println("Number is even");
            }else{
                System.out.println("Number is odd");
            }
        }catch(Exception e){
            System.out.println("Please make sure that you entered a interger");
        }
    }
}
