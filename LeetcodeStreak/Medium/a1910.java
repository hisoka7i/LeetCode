package LeetcodeStreak.Medium;

public class a1910 {
    public static void main(String[] args) {
        
    }
    public static String removeOccurrences(String s, String part) {
        if(!s.contains(part)){
            return s;
        }
        int index = s.indexOf(part);
        String left = s.substring(0, index);
        String right = s.substring(index+part.length());
        return removeOccurrences(left+right, part);
    }
}
