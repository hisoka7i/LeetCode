public class findMean {
    public static void main(String[] args){
        int[] nums = {1,3,2};
        System.out.println(findMean(nums, nums.length));
    }
    static float findMean(int[] nums, int N){
        if(N==1){
            return (float)nums[N-1];
        }
        return ((float)findMean(nums,N-1)*(N-1)+ nums[N-1])/N;
    }
}
