package ArrayQuestions;
public class a628 {
    public static void main(String[] args) {
        int[] sample = {1,2,3};
        System.out.println(product(sample));
    }
    public static int product(int[] sample){
        if(sample.length<3)return 0;
        Integer num1 = null, num2 = null, num3=null,min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        //See the trick is to find the 3 largest numbers and 2 smallest numbers 
        //Then do the cal of 3 largest or 2 smallesr and 1 largest
        for(Integer num: sample){
            if(num1==null || num>num1){
                num3=num2;
                num2=num1;
                num1=num;
            }else if(num2==null || num>num2){
                num3=num2;
                num2=num;
            }else if(num3==null || num>num3){
                num3=num;
            }
            if(num<min1){
                min2=min1;
                min1=num;
            }else if(num<min2){
                min2=num;
            }
        }
        return Math.max(num1*num2*num3, num1*min1*min2);
    }
}
