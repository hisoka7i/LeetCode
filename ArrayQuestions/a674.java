package ArrayQuestions;
public class a674 {
    public static void main(String[] args) {
        int[] sample = {1,3,5,4,7};
        System.out.println(findLength(sample));
    }
    public static int findLength(int[] nums){
        int max = 1;
        int count = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]){
                count++;
                if(count>max){
                    max=count;
                }
            }else{
                count=1;
            }
        }
        return max;
    }
}
