import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class a217 {
    public static void main(String[] args) {
        
    }
    public static boolean containsDub(int[] sample){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<sample.length;i++){
            if(!hs.add(sample[i]))return true;
            hs.add(sample[i]);
        }
        return false;
    }
}
