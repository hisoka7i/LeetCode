import java.util.Arrays;

public class a350 {
    //Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
    public int[] intersect(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        int i = 0, j = 0, index = 0;
        while(i<num1.length && j<num2.length){
            if(num1[i] == num2[j]){
                //we are storing similar values in num1.
                num1[index++] = num2[j];
                i++;
                j++;
            }
            else if(num1[i]<num2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] output_array = new int[index];
        for(i=0;i<index;i++){
            output_array[i] = num1[i];
        }
        return output_array;
    }
}
