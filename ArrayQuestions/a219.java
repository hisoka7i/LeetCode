package ArrayQuestions;
import java.util.HashMap;
import java.util.Map;

public class a219 {
    public static void main(String[] args) {
        int []nums = {1,0,1,1};
        int k = 3;
        System.out.println(""+'"');
        System.out.println(check(nums, 1));
    }
    public static boolean check(int[] sample, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<sample.length;i++){
            if(!map.containsKey(sample[i]))
                map.put(sample[i], i);
            else {
                System.out.println(map.get(sample[i]));
                System.out.println(i);
                if(Math.abs(i-map.get(sample[i]))<=k)return true;
                else map.put(sample[i], i);
            }
        }
        return false;
    }
}
