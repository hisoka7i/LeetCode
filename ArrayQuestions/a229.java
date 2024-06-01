package ArrayQuestions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.RowFilter.Entry;

public class a229 {
    public static void main(String[] args) {
        
    }
    //space complexity for this is O(n) which is not good.
    public static List<Integer> majorityElement(int[] sample){
        List<Integer> output = new ArrayList<>();
        Map<Integer,Integer> maping = new HashMap<>();
        for(Integer num: sample){
            maping.put(num, maping.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: maping.entrySet()){
            if(entry.getValue()>sample.length/3){
                output.add(entry.getKey());
            }
        }
        return output;
    }
}
