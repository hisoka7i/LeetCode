public class a1903 {
    public static void main(String[] args) {
        String num = "52";
        System.out.println(largestOddNumber(num));
    }
    public static String largestOddNumber(String num) {
        int n = num.length();
        for(int i=n-1;i>=0;i--){
            int number = Integer.valueOf(num.charAt(i));
            if((number%2)==1)return num.substring(0, i+1);
        }
        return "";
    }
}
