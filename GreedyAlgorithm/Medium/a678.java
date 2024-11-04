package GreedyAlgorithm.Medium;

public class a678 {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        char[] character_array = s.toCharArray();
        for(int i=0; i<character_array.length;i++){
            if(character_array[i]=='('){
                min += 1;
                max += 1;
            }
            else if(character_array[i]==')'){
                min -= 1;
                max -= 1;
            }else{
                min -= 1;
                max += 1;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min == 0;
    }
}
