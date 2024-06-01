package ArrayQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a18 {
    public static void main(String[] args) {
        int[] sample = {1,0,-1,0,-2,2};
        System.out.println(fourSum(sample, 0));
    }
    public static List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            //removing duplicates
            if(i>0 && nums[i]==nums[i-1])continue;
            System.out.println(9);
            for(int j=i+1;j<n;j++){
                //removing duplicates
                if(j!=i+1 && nums[j]==nums[j-1])continue;
                System.out.println(1);
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum = nums[i]+nums[j]+nums[k]+nums[l];
                    System.out.println(2);
                    if(sum>target){
                        l--;
                    }
                    else if(sum<target){
                        k++;
                    }else{
                        List<Integer> current = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        System.out.println(current);
                        output.add(current);
                        k++;
                        l--;
                        //removing duplicates
                        while(k<l && nums[k]==nums[k-1])k++;
                        while(k<l && nums[l]==nums[l+1])l--;
                    }
                }
            }
        }
        System.out.println("4");
        return output;
    }
}
