package Contest.WeeklyContest;

public class LexicographicallySmallest {
    /*
     * Given a string s containing only digits, 
     * return the lexicographically smallest string that
     *  can be obtained after swapping adjacent digits in s with the
     *  same parity at most once.
     * Digits have the same parity if both are odd or both are even. 
     * For example, 5 and 9, as well as 2 and 4, have the same parity, 
     * while 6 and 9 do not.
    */
    public static void main(String[] args) {
        System.out.println(getSmallestString("45320"));
    }
    public static String getSmallestString(String s) {
        char[] number_array = s.toCharArray();
        for(int i=0;i<number_array.length-1;i++){
            if(number_array[i]%2==0 && number_array[i+1]%2==0){
                if(number_array[i]>number_array[i+1]){
                    char temp = number_array[i];
                    number_array[i] = number_array[i+1];
                    number_array[i+1] = temp;
                    break;
                }
            }else if(number_array[i]%2!=0 && number_array[i+1]%2!=0){
                if(number_array[i]>number_array[i+1]){
                    char temp = number_array[i];
                    number_array[i] = number_array[i+1];
                    number_array[i+1] = temp;
                    break;
                }
            }
        }
        s = "";
        for(char current_number: number_array){
            s += current_number;
        }
        return s;
    }
}
