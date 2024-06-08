package StackAndQueue;

public class a402 {
    public static void main(String[] args) {
        removeKdigits("112", 1);
    }
    //without stack 
    public static String removeKdigits(String num, int k) {
        //Idea behind this solution is
        StringBuilder sb = new StringBuilder();

        for(char current_digit: num.toCharArray()){
            //next digit is less than the current digit
            //remove the current digit,, 
            while(k>0 && sb.length()>0 && sb.charAt(sb.length()-1)>current_digit){
                k--;
                //deleting the last element
                sb.setLength(sb.length()-1);
            }
            sb.append(current_digit);
        } 

        //This is to handle case, if k is not equal to zerp
        //from the above logic we could not remove any digit
        //so we simply delete the last k digits
        sb.setLength(sb.length() - Math.min(k, sb.length()));

        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        String ans = sb.substring(start);
        return ans.isEmpty() ? "0" : ans;
    }
}
