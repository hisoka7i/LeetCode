package ArrayQuestions.PracticeQuestions;

import java.util.HashMap;
import java.util.Map;

public class a3158 {
    //Find the XOR of Numbers Which Appear Twice
    public static void main(String[] args) {
        System.out.println(duplicateNumbersXOR2(new int[]{1,2,1,3}));
    }

    //without using hashmap
    public static int duplicateNumbersXOR2(int[] nums) {
        int result = 0;
        boolean[] checkTable = new boolean[51];

        for(int current: nums){
            if(checkTable[current]){
                result ^= current;
            }else{
                checkTable[current]=true;
            }
        }
        return result;
    }

    //withusing hashmap 
    public static int duplicateNumbersXOR(int[] nums) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int current:nums){
            int value = map.getOrDefault(current,0);
            map.put(current, value+1);
        }
        for(Map.Entry<Integer,Integer> mappedValiue: map.entrySet()){
            if(mappedValiue.getValue()>=2 && mappedValiue.getValue() % 2 == 0){
                result ^= mappedValiue.getKey();
            }
        }
        return result;
    }
}
