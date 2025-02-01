package NeetcodeDSASheet.ArrayAndHashing;
import java.util.Arrays;

public class ProductOfArrayItself {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean zero_flag = false;
        int zero_count = 0;
        for(int number: nums){
            if(number == 0){
                zero_flag = true;
                zero_count++;
            }else{
                product *= number;
            }
        }
        if(zero_count > 1){
            Arrays.fill(nums, 0);
            return nums;
        }
        for(int i=0;i<nums.length;i++){
            if(zero_flag){
                if(nums[i] == 0){
                    nums[i] = product;
                }else{
                    nums[i] = 0;
                }
            }else{
                if(nums[i] != 0)
                nums[i] = product/nums[i];
            }
        }
        return nums;
    }
}
