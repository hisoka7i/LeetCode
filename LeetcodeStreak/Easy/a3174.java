package LeetcodeStreak.Easy;

public class a3174 {
    public String clearDigits(String s) {
        StringBuffer sb = new StringBuffer("");
        for(char character: s.toCharArray()){
            if(character>='a' && character<='z'){
                sb.append(character);
            }else{
                if(sb.length()!=0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
}
