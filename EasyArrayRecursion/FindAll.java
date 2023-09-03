import java.util.List;
import java.util.ArrayList;
public class FindAll {
    public static void main(String[] args){
        int[] arr = {1,2,4,2,3,4,5,4};
        System.out.println(findAll(arr,2,0));
    }
    static List<Integer> findAll(int[] nums,int target, int index){
        List<Integer> list = new ArrayList<>();
        if(index>nums.length-1){
            return list;
        }
        if(nums[index]==target){
            list.add(index);
        }
        List<Integer> answersFromBelow = findAll(nums, target, index+1);
        list.addAll(answersFromBelow);
        return list;

    }
}
