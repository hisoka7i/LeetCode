import java.util.Arrays;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int overall_product = 1;
        int count_zero = 0;
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(num != 0)
                overall_product = overall_product * num;
            else
                count_zero++;
        } //this is 
        int[] answer_array = new int[nums.length];
        if(count_zero > 0){
            Arrays.fill(answer_array, 0);
            if(count_zero > 1){
                return answer_array;
            }
            for(int i = 0; i<nums.length; i++){
                if(nums[i] == 0){
                    answer_array[i] = overall_product;
                }
            }
            return answer_array;
        }
        for(int i=0;i<nums.length;i++){
            answer_array[i] = overall_product/nums[i];
        }

        return answer_array;
    }
}
