public class a541 {
    public static void main(String[] args) {
        
    }

    //This is the same code as below, just much better
    public static String reverseStr(String s, int k) {
        char[] characterArray = s.toCharArray();
        for(int i=0;i<s.length();i+=(2*k)){
            int left = i;
            int right = Math.min(i+k-1, s.length()-1);
            while(left<right){
                char temp = characterArray[left];
                characterArray[left++]=characterArray[right];
                characterArray[right--]= temp;
            }

        }
        return String.valueOf(characterArray);
    }
    public static String reverseStr2(String s, int k) {
        char[] characterArray = s.toCharArray();
        int ptr1 = 0;
        int ptr2 = k;

        if(ptr1+k<s.length()){
            reverseArray(characterArray, ptr1, s.length()-1);
            return String.valueOf(characterArray);
        }
        if(ptr2+k<s.length()){
            reverseArray(characterArray, ptr1, ptr2);
            return String.valueOf(characterArray);
        }
        for(int i=0;i<s.length();i++){
            if(ptr2+2*k<s.length()){
                reverseArray(characterArray, ptr1, ptr2);
            }else{
                if(ptr1+2*k<s.length()-1){
                    reverseArray(characterArray, ptr1, s.length()-1);  
                }
            }
        }
        return String.valueOf(characterArray);
    }
    public static void reverseArray(char[] characterArray, int ptr1, int ptr2){
        for(int i=ptr1;i<characterArray.length/2;i++){
            char temp = characterArray[ptr1];
            characterArray[ptr1] = characterArray[ptr2];
            characterArray[ptr2] = temp;
        }
    }
}
