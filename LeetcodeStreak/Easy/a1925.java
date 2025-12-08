
import java.util.HashSet;
import java.util.Set;
public class a1925 {
    public static void main(String[] args) {
        
    }

    public static int countTriples(int n) {
        Set<Integer> values = new HashSet<>();
        int count = 0;
        for(int i = 1; i<=n; i++){
            values.add(i*i);
        }

        for(int i = n; i > 0; i--){
            for(int j = n-1; j > 0; j--){
                if(values.contains(i*i - j*j)){
                    count++;
                }
            }
        }
        return count;
    }
}
