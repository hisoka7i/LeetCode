package PracticeQuestion;

public class a20 {
    public static void main(String[] args) {
        int num = 1290;
        System.out.println(intToRoman(num));
    }
    public static String intToRoman(int num) {
       int[] values = {1000, 900, 500, 400, 100, 90, 50 , 40, 10, 9, 5, 4, 1};
       String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
       //This will be used to create output
        StringBuilder output = new StringBuilder();

        for(int i=0;i<values.length;i++){
            //here we will be iterating the loop
            while(num >= values[i]){
                //here from the highest number we will be comparing,
                num -= values[i];
                //we will subtract the greatest number from the values array
                //and add it's corresponding symbol into the output string
                output.append(symbols[i]);
                //dry run this question to better understand the solution
            }
        }
       return output.toString();
   }
}
