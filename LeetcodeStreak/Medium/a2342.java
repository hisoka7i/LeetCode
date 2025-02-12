package LeetcodeStreak.Medium;

import java.util.HashMap;
import java.util.Map;

public class a2342 {
    public static void main(String[] args) {
        maximumSum(new int[]{18,43,36,13,7});
    }
    public static int maximumSum(int[] nums) {
        //helps to maintain the, count
        Map<Integer,Integer[]> mapping = new HashMap<>();
        int maxSum = 0;
        for(int num:nums){
            int key = sumOfDigits(num);
            if(mapping.containsKey(key)){
                Integer[] values = mapping.get(key);
                if(num >= values[1]){
                    values[0] = values[1];
                    values[1] = num;
                }
                if(num > values[0] && num < values[1]){
                    values[0] = num;
                }
                maxSum = Math.max(maxSum, (values[0] + values[1]));
            }else{
                //means the number is not present
                mapping.put(key,new Integer[]{0,num});
            }
        }
        return maxSum;
    }
    public static int sumOfDigits(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
}
