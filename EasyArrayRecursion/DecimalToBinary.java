public class DecimalToBinary {
    public static void main(String[] args){
        System.out.println(convert(10));
    }
    static String convert(int n){
        if(n==1){
            return "1";
        }
        return (n%2)+""+convert(n/2);
    }
}
