package PracticeQuestion;

public class a521 {
    public static void main(String[] args) {
        
    }

    public static int findLUSlength(String a, String b) {
        // a is equal to b..
        if(a.equals(b)){
            return -1;
        }
        int count = 0;
        
        if(a.length() < b.length()){
            return findLUSlength(b, a);
        }

    }
}
