import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,1,2};
        int[] nums2 = {2,2};
        interception(nums1, nums2);
    }
    public static int[] interception(int[] nums1,int[] nums2){
        if(nums1.length==0 || nums2.length==0){
            return new int[0];
        }
        Set<Integer> values = new HashSet<>();
            for(Integer num:nums1){
                values.add(num);
            }
        System.out.println(values);
        List<Integer> output = new ArrayList<Integer>();
        for(int i=0;i<nums2.length;i++){
            if(values.contains(nums2[i])){
                if(!output.contains(nums2[i]))
                    output.add(nums2[i]);
            }
        }
        System.out.println(output);
        int[] out = new int[output.size()];
        for(int i=0;i<out.length;i++){
            out[i]=output.get(i);
        }
        return out;
    }
}
