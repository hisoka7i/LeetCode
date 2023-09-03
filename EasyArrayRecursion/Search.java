public class Search{
  public static void main(String[] args){
    int[] arr = {1,4,23,12,15,25};
    System.out.println(find(arr,11,0));
  }
  static boolean find(int[] nums,int target,int count){
    if(count==nums.length){
      return false;
    }
    return nums[count]==target || find(nums,target,count+1);
  }
}
