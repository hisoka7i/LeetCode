package ArrayQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a697 {
    public static void main(String[] args) {
        int[] sample = {1,2,2,3,1};
        degree(sample);
        // System.out.println(Integer.MAX_VALUE);
    }
    //mysolution uses 24ms.
    public static int degree(int[] sample){
        if(sample.length==1)return 1;
        int output = Integer.MAX_VALUE;
        boolean flag = false;
        Map<Integer,List<Integer>> mapping = new HashMap<>();
        int max = 0;
        for(int i=0;i<sample.length;i++){
            if(!mapping.containsKey(sample[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mapping.put(sample[i],list);
            }else{
                mapping.get(sample[i]).add(i);
                if(mapping.get(sample[i]).size()>max){
                    max = mapping.get(sample[i]).size();
                }
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry: mapping.entrySet()){
            if(entry.getValue().size()==max){
                int sum = entry.getValue().get(max-1)-entry.getValue().get(0)+1;
                if(sum<output){
                    output=sum;
                    flag = true;
                }
            }
        }
        if(flag)
            return output;
        else
            return 1;
    }
}
