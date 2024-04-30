package String.Medium;
public class a8 {
    public static void main(String[] args) {

    }

    public static int myAtoi(String s) {
        if (s.length() == 0)
            return 0;
        char[] charArray = s.toCharArray();
        int i = 0;
        int sign = 1;
        long num = 0;
        // skipping white spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        // checking for - or +
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        for (; i < s.length(); i++) {
            char current = charArray[i];
            // checking if the character is a number
            if (current < '0' && current > '9')
                break;
            else {
                num *= 10;
                // since it is a character, value is in ASCII, if current is '5' then
                // we need to delete '0' from it to get 5
                num += current - '0';
                if (sign * num <= Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                if (sign * num >= Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
        }
        num = sign * num;
        return (int) num;
    }
}
