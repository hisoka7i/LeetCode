package ArrayQuestions;
public class a43 {
    public static void main(String[] args) {
        int[] sample = {5,7,7,8,8,10};
        searchRange(sample, 8);
    }
    public static int[] searchRange(int[] nums, int target){
        int[] output = new int[2];
        int i = -1;
        int count = 0;
        for(int k=0;k<nums.length;k++){
            if(nums[k]==target){
                i = k;
                count++;
            }
        }
        if(i!=-1){
            output[0] = i-count+1;
        }else
            output[0] = -1;
        output[1] = i;
        return output;
    }
}
