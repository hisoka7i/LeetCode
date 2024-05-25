public class findMean {
    public static void main(String[] args){
        int[] nums = {1,3,2};
        System.out.println(findMeanRec(nums, nums.length));
    }
    static float findMeanRec(int[] nums, int N){
        if(N==1){
            return (float)nums[N-1];
        }
        return ((float)findMeanRec(nums,N-1)*(N-1)+ nums[N-1])/N;
    }
}
