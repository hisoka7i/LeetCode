package ArrayQuestions.PracticeQuestions;

import java.util.HashSet;
import java.util.Set;

public class a1346 {
    public static void main(String[] args) {
        
    }
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> container = new HashSet<>();

        for(int i:arr){
            if(container.contains(2*i) || (i%2==0 && container.contains(i/2)))
                return true;
            container.add(i);
        }
        return false;
    }
}
