package NeetcodeDSASheet.TwoPointers;

public class ValidPalindrome {
    //using two pointers
    public boolean isPalindrome(String s) {
        String sample = s.toLowerCase();
        int p1 = 0;
        int p2 = sample.length() - 1;
    
        while (p1 < p2) {
            char left = sample.charAt(p1);
            char right = sample.charAt(p2);
    
            // Skip non-alphanumeric characters
            if (!(left >= 'a' && left <= 'z') && !(left >= '0' && left <= '9')) {
                p1++;
                continue;
            }
            if (!(right >= 'a' && right <= 'z') && !(right >= '0' && right <= '9')) {
                p2--;
                continue;
            }
    
            // Compare the characters
            if (left != right) {
                return false;
            }
    
            // Move pointers inward
            p1++;
            p2--;
        }
    
        return true;
    }
    
}
