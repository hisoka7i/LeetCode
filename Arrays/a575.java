import java.util.HashMap;
import java.util.Map;

public class a575 {
    public static void main(String[] args) {
        int[] sample = {1,1,2,3};
        System.out.println(distributeCandies(sample));
    }
    //37ms approach
    public static int distribution(int[] candytype){
        Map<Integer,Integer> mapping = new HashMap<>();
        for(Integer candy: candytype){
            mapping.put(candy, mapping.getOrDefault(candy,0)+1);
        }
        if(mapping.size()>candytype.length/2){
            return candytype.length/2;
        }
        return mapping.size();
    }
    //4ms appraoch, it is done by using steve of eurothese method
    public static int distributeCandies(int[] candyType) {
        boolean[] types = new boolean[200001];
        int count = 0;
        for(int candy: candyType){
            int candyTypePos = candy + 100000;
            if(!types[candyTypePos]){
                if(++count == candyType.length/2)return count;
                types[candyTypePos]=true;
            }
        }
        return count;
    }

}
