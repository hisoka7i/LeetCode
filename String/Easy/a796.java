public class a796 {
    public static void main(String[] args) {
        String s = "abcde";
        String e = "bcdef";
        rotateString(s, e);
    }
    //my solution 
    public static boolean rotateString(String s, String goal) {
        String rotated = "";
        char initial;
        for(int i=0;i<s.length();i++){
            initial = s.charAt(0);
            rotated = s.substring(1, s.length());
            s = rotated+initial;
            if(s.equals(goal))
                return true;
        }
        return false;
    }
    //0 ms soltion
    public static boolean rotateString0ms(String s, String goal) {
        if(s.length()!=goal.length())return false;

        return (goal+goal).contains(s);
    }
}
