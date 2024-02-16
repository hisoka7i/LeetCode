import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a350 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,1,2};
        int[] nums2 = {2,2};
        interception(nums1, nums2);
    }
    public static int[] interception(int[] nums1,int[] nums2){
        if(nums1.length==0 || nums2.length==0){
            return new int[0];
        }
        List<Integer> values = new ArrayList<>();
            for(Integer num:nums1){
                values.add(num);
            }
        List<Integer> output = new ArrayList<Integer>();
        for(int i=0;i<nums2.length;i++){
            if(values.contains(nums2[i])){
                    output.add(nums2[i]);
                    values.remove(nums2[i]);
            }
        }
        int[] out = new int[output.size()];
        for(int i=0;i<out.length;i++){
            out[i]=output.get(i);
        }
        return out;
    }
    public static int[] betterApproach(int[] num1, int[] num2){
        int i=0,j=0,index=0;
        Arrays.sort(num1);
        Arrays.sort(num2);
        while(i<num1.length && j<num2.length){
            if(num1[i]==num2[j]){
                num1[index++] = num2[j];
                i++;
                j++;
            }else if(num1[i]<num2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] output = new int[index];
        for(i=0;i<index;i++){
            output[i]=num1[i];
        }
        return output;
    }
}
