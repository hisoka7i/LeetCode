package String.Medium;

public class a13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            // subtractive notation rule
            // "IV" represents 4 (5 - 1)
            // "IX" represents 9 (10 - 1)
            // "XL" represents 40 (50 - 10)
            // "XC" represents 90 (100 - 10)
            // "CD" represents 400 (500 - 100)
            // "CM" represents 900 (1000 - 100)

            //4 is being used because 4 is just before 5 which is IV and 9 is just before 10
            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;
    }
}
