public class FindPosition{
    public static void main(String[] args){
        int[] arr = {1,2,4,6,5,9};
        System.out.println(findPos(arr,1,0));
    }
    static int findPos(int[] nums,int target,int index){
        if(index>(nums.length-1)){
            return -1;
        }
        if(nums[index]==target){
            return index;
        }
        return findPos(nums, target, index+1);
    }
}