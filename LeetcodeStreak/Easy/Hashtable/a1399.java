package LeetcodeStreak.Easy.Hashtable;

import java.util.HashMap;
import java.util.Map;

public class a1399 {
    public int countLargestGroup(int n) {
        if(n < 10)
            return n;
        
        Map<Integer,Integer> hashtable = new HashMap<>();
        int max  = 0;
        for(int i=1;i<=n;i++){
            int sum = sumOfInteger(i);
            hashtable.put(sum, hashtable.getOrDefault(sum, 0)+1);
            //we can simply get the max value here
            max = Math.max(max, hashtable.get(sum));
        }

        int count =0;
        for (Map.Entry<Integer, Integer> kvpair : hashtable.entrySet()) {
            if (kvpair.getValue() == max) {
                ++count;
            }
        }
        return count;
    }

    public int sumOfInteger(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n = n/10;
        }
        return  sum;
    }
}
