package ArrayQuestions;
import java.util.*;
class arrayshift {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] nums1 = new int[nums.length];
        for(int i=0;i<nums.length; i++){
          nums1[i]=nums[i];
        }
        Arrays.sort(nums1);
        for(int i=0,j=nums1.length-1; i<nums1.length/2; i++,j--){
            int temp = nums1[i];
            nums1[i]=nums1[j];
            nums1[j]=temp;
        }
        int j=0;
        for(int i=0;i<nums.length;i++){
          if(nums[i]!=0){
            nums1[j]=nums[i];
            j++;
          }
        }
        nums = nums1;
        for(int i=0;i<nums.length;i++){
          System.out.println(nums[i]);
        }

    }
}
