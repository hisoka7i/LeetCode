import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class a414 {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1,6,1,2,4,3,2,1};
        System.out.println(thirdMaxBetter(nums));
    }
    public static Integer thirdMax(int[] nums){
        Arrays.sort(nums);
        List<Integer> sample = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!sample.contains(nums[i]))
                sample.add(nums[i]);
        }
        if(sample.size()<3){
            return sample.get(sample.size()-1);
        }
        return sample.get(sample.size()-3);
    }
    public static Integer thirdMaxBetter(int[] nums){
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) {
                continue;
            }

            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }

        return max3 != null ? max3 : max1;
    }
}
