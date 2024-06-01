package ArrayQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a506 {
    public static void main(String[] args) {
        int[] sample = {10,3,8,9,4};
        relative(sample);
    }
    public static String[] relative(int[] sample){
        String[] output = new String[sample.length];
        int[] sum = sample;
        Arrays.sort(sum);
        int i=0;
        int n = sample.length;
        while (i<n) {
            for(int j=0;j<n;j++){
                if(sample[i]==sum[j]){
                    if(j==0){
                        output[j]="Gold Medal";
                    }
                    else if(j==1){
                        output[i]="Silver Medal";
                    }
                    else if(j==2){
                        output[i]="Bronze Medal";
                    }else{
                        output[i]=""+(j+1);
                    }
                    i++;
                }  
            }
        }
        for(String str:output){
            System.out.print(str+" ");
        }
        return output;
    }
}
