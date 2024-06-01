package ArrayQuestions;
import java.util.Arrays;

public class a3046 {
    public static void main(String[] args) {
        
    }
    public static boolean isPossible(int[] nums){
        Arrays.sort(nums);
        if(nums.length%2!=0)return false;
        int count =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                count++;
            }else{
                count=1;
            }
            if(count>2){
                return false;
            }
        }
        return true;
    }
}
