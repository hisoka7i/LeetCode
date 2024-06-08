package ArrayQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.IntersectionType;

public class a599 {
    public static void main(String[] args) {
        String[] sample1 = {"happy","sad","good"};
        String[] sample2 = {"sad","happy","good"};
        System.out.println(findRes(sample1, sample2, 0));
    }
    //6ms solution 
    public static String[] findRes(String[] list1,String[] list2, int pp){
        Map<String,Integer> mpp = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            mpp.put(list1[i],i);
        }
        int max = Integer.MAX_VALUE;
        List<String> output = new ArrayList<>();
        for(int i=0;i<list2.length;i++){
            Integer k = mpp.get(list2[i]);
            if(k!=null && k+i<=max){
                if(k+i!=max){
                    output.clear();
                    max=k+i;
                    output.add(list2[i]);
                }else output.add(list2[i]);
            }
        }
        return output.toArray(new String[0]);
    }

    //this is taking 86ms
    public static String[] findRes(String[] list1, String[] list2){
        Object[] finalArray = new Object[list1.length+list2.length];
        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list1[i].equals(list2[j])){
                    if(finalArray[i+j]!=null){
                        List<String> countString = (List<String>)finalArray[i+j];
                        countString.add(list1[i]);
                        break;
                    }else{
                        List<String> countString = new ArrayList<>();
                        countString.add(list1[i]);
                        finalArray[i+j]=countString;
                        break;
                    }
                }
            }
        }
        for(int i=0;i<finalArray.length;i++){
            if(finalArray[i]!=null){
                List<String> output = (List<String>)finalArray[i];
                return output.toArray(new String[0]);
            }
        }
        return null;
    }
}
