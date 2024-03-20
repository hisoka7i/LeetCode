import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.PortableInterceptor.INACTIVE;

public class ThreeSum {
    public static void main(String[] args){
        int[] sample = {-1,0,1,2,-1,-4};
        System.out.println(ThreesumFunction(sample));
    }
    public static List<List<Integer>> ThreesumFunction(int[] sample){
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(sample);
        int n = sample.length;
        //This will be our 1st pointer
        for(int i=0;i<n;i++){
            //we are removing duplicates using this function
            if(i!=0 && sample[i-1]==sample[i])continue;

            //This is our 2nd pointer
            int j = i+1;
            //This is our 3rd pointer
            int k = n-1;
            while(j<k){
                int sum = sample[i]+sample[j]+sample[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    List<Integer> answer = Arrays.asList(sample[i],sample[j],sample[k]);
                    output.add(answer);
                    j++;
                    k--;
                    //skipping the duplicates using this
                while(j<k && sample[j-1]==sample[j])j++;
                while(j<k && sample[k]==sample[k+1])k--;
                }
            }
        }
        return output;
    }
}
