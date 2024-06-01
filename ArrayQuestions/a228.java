package ArrayQuestions;
import java.util.ArrayList;
import java.util.List;

public class a228 {
    public static void main(String[] args) {
        int[] sample = {0,2,3,4,6,8,9};
        System.out.println(summaryRange(sample));
    }
    public static List<String> summaryRange(int[] sample){
        int ptr1 = 0,ptr2 = 0;
        List<String> output = new ArrayList<>();
        while(ptr1<sample.length && ptr2<sample.length){
            if(ptr1==ptr2 && ptr2==(sample.length-1)){
                String str = ""+sample[ptr1];
                output.add(str);
                return output;
            }
            if(ptr2<sample.length-1 && sample[ptr2]+1 == sample[ptr2+1]){
                ptr2++;
            }else{
                String str = null;
                if(ptr1==ptr2){
                    str = ""+sample[ptr1];
                }else{
                    str = sample[ptr1]+"->"+sample[ptr2];
                }
                output.add(str);
                ptr1=ptr2+1;
                ptr2 = ptr2+1;
            }
        }
        return output;
    }
}
