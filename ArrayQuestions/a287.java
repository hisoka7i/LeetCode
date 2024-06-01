package ArrayQuestions;

public class a287 {
    public static void main(String[] args) {
        
    }
    public static int findDuplicate(int[] nums) {
        int[] integer_array = new int[Integer.MAX_VALUE];
        for(int i=0;i<nums.length;i++){
            if(integer_array[nums[i]]==1){
                return nums[i];
            }
            integer_array[nums[i]]++;
        }
        return -1;
    }
}
