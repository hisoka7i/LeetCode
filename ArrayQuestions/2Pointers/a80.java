import java.util.Arrays;
import java.util.List;

public class a80 {
    public static void main(String[] args) {
        int[] sample = {0,1,1,1,1,2,3,3,3,3,4,4,5,6,7,7,7};
        removeDuplicates(sample);
    }
    public static int removeDuplicates(int[] nums){
        if(nums.length<3)return nums.length;
        //we will fix first 2 indexes
        //and from the 3 index we will check if it matches with the index - 2
        //then we will change, the value of the index with next value in the array
        //and we will increment the index
        int index = 2;
        for(int i=2;i<nums.length;i++){
            if(nums[index]==nums[index-2]){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
    public static int removeDuplicates2(int[] nums) {
        //we will use 3 pointers
        //one to count, others to iterate p1 and p2
        if(nums.length<=2){
            return nums.length;
        }
        int count = 0;
        int p1 = 0;
        for(int p2=1;p2<nums.length;p2++){
            int value2 = nums[p2];
            int value1 = nums[p1];
            if(value1!=value2){
                if(p2-p1-1 == 1){
                    nums[count+1]=value1;
                    count++;
                }else if(p2-p1-1 >= 2){
                    if(count!=0){
                        nums[count+1]=value1;
                        nums[count+2]=value1;
                    }
                    count=count+2;
                }
                p1=p2;
            }
            p2++;
        }
        
        return count;
    }
}
