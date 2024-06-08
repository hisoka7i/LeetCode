package ArrayQuestions;
import java.util.Arrays;

public class a645 {
    public static void main(String[] args) {
        int[] sample = {1,5,3,2,2,7,6,4,8,9};
        System.out.println(duplicateNew(sample)[0] + " " + duplicateNew(sample)[1]);
    }
    public static int[] duplicateNew(int[] sample){
        int[] output = new int[2];
        Arrays.sort(sample);
        int ptr = 0;
        int sum1 = sample[0];
        int sum2 = 1;
        for(int i=1;i<sample.length;i++){
            if(sample[i-1] == sample[i]){
                ptr = i;
            }
            sum2 += i+1;
            sum1 += sample[i];
        }
        output[0]=sample[ptr];
        output[1]=sample[ptr]+(sum2 - sum1);
        return output;
    }
}
