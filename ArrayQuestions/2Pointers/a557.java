package ArrayQuestions.2Pointers;

public class a557 {
    public static void main(String[] args) {
        
    }
    public static String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        for(int i=0;i<s.length();i++){
            if(charArray[i]!=' '){
                left = i;
                int right = i;
                while(charArray[i]!=' '){
                    if(i==s.length()-1){
                        right = i;
                    }
                    right = i;
                    i++;
                }
                while (left<right) {
                    char temp = charArray[left];
                    charArray[left++] = charArray[right];
                    charArray[right--] = temp;
                }
            }
        }
        return String.valueOf(charArray);
    }
}
