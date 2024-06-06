package String.PracticeQuestion;

public class a680 {
    // Valid Palindrome II
    public static boolean validPalindrome(String s) {
        char[] characterArray = s.toCharArray();

        //creating a left and right array 
        int l=0;
        int r=characterArray.length-1;

        while (l<r) {
            if(characterArray[l]!=characterArray[r]){
                return (compare(l+1, r, characterArray) || compare(l, r-1, characterArray));
            }
            l++;
            r--;
        }
        return true;
    }
    public static boolean compare(int l,int r,char[] arr){
        while(l<r){
            if(arr[l]!=arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
