package ArrayQuestions.MediumPractice;

import java.util.Arrays;
import java.util.Comparator;

public class a179 {

    //Better approach 
    //is through comparator
    //comvert eveything into the string and then do the comparison before adding 
    //using a comparator
    public String largestNumber(int[] nums) {
        String s[] = new String[nums.length];

        //adding the values into the string array
        for(int i=0;i<nums.length;i++){
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, (a,b)->(b+a).compareTo(a+b));
        //here we will do lexiographical comparison between 9 and 34
        //if 934 is greater or 349;

        StringBuffer result = new StringBuffer();

        for(String current_item: s){
            result.append(current_item);
        }

        return result.toString();

    }

    //This was my initial thought but this is too much of a hustle to implement
    //Intution, get every number
    //for every integer, make a logic, which will compare and switch
    public String largestNumber2(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int current_integer = nums[i];
            helperFunction(nums, i, current_integer);
        }
        return null;
    }
    public void helperFunction(int[] nums, int start, int integer){
        //getting the first digit
        int max_index = 0;
        //need to get starting digit here
        int starting_digit;
        for(int j=start;j<nums.length;j++){

        }
    }
}
