package ArrayQuestions;
public class a3038 {
    public static void main(String[] args) {
        int sample[] = {3,2,1,4,3,2,6,1,4};
        System.out.println(maxOperations(sample));
    }
    public static int maxOperations(int[] nums){
        int count = 1;
        if(nums.length==1)return -1;
        if(nums.length <= 3)return 1;
        int sum = nums[0]+nums[1];
        for(int i=3;i<nums.length;i=i+2){
            if(sum == (nums[i-1]+nums[i]))count++;
            else return count;
        }
        return count;
    }
}
