public class DecodingCode {
    public int numDecodings(String s) {
        return helper_function(s.toCharArray(), 0);
    }
    public int helper_function_wrong(char[] s, int i){
        if(s[i] - 'a' > 26)return 0;
        if(s[i] - 'a' < 0)return 0;

        if(i < s.length - 1 && (s[i] - 'a' + s[i+1] - 'a') < 26){
            return 2 + helper_function(s, i+1);
        }else{
            return 1 + helper_function(s, i +1 );
        }
    }

    //my thought process was correct but the implementation was wrong
    //simply add memo into this and every thing is right
    public int helper_function(char[] s, int i){
        if(i == s.length )return 1;
        if( s[i] == 0)return 0;

        int count = helper_function(s, i+1);

        if(i < s.length - 1){
            int num = s[i]*10 + s[i+1];
            if(num >= 10 && num <= 26){
                count += helper_function(s, i+2); 
            }
        }
        return count; 
    }

}
