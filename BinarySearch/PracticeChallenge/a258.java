package BinarySearch.PracticeChallenge;

public class a258 {
    public static void main(String[] args) {
        System.out.println(addDigits(11));
    }
    public static int addDigits(int num) {
        while (num>9) {
            //This is the formula
            num= num%10 + num/10;
        }
        return num;
    }
}
