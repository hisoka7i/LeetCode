package NeetcodeDSASheet.ArrayAndHashing;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j;
        for(i=0;i<nums.length; i++){
            for(j = i+1; j<nums.length; j++){
                if(nums[i] == target - nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}
