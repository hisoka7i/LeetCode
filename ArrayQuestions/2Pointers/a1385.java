package ArrayQuestions.2Pointers;

import java.util.Arrays;


public class a1385 {
    //Find the Distance Value Between Two Arrays
    public static void main(String[] args) {
        
    }
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr2[j]-arr1[i])<=d){
                    count++;
                    break;
                }
            }
        }
        return (arr1.length-count);
    }
}
