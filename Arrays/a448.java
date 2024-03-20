import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a448 {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(missingNums(nums));
    }
    public static List<Integer> missingNums(int[] nums){
       Set<Integer> values = new HashSet<>();
       for(int i=0;i<nums.length;i++){
        values.add(nums[i]);
       }
       List<Integer> output = new ArrayList<>();
       for(int i=1;i<=nums.length;i++){
        if(!values.contains(i)){
            output.add(i);
        }
       }
       return output;
    }
    public static List<Integer> betterApproach(int[] nums){
        int[] sample = new int[nums.length + 1];
        for(int i=0;i<nums.length;i++){
            sample[nums[i]]=1;
        }
        List<Integer> output = new ArrayList<>();
        for(int i=1;i<sample.length;i++){
            if(sample[i]==0){
                output.add(i);
            }
        }
        return output;
    }
}
