import java.util.HashMap;
import java.util.Map;

public class SubarraysWithXorK {
    public static void main(String[] args) {
        
    }
    
    public static int subarray(int[] sample, int k){
        int count =0;
        //we will maintain prefix array of XOR
        Map<Integer,Integer> mpp = new HashMap<>();
        int xr = 0;
        mpp.put(xr, 1);
        for(int i=0;i<sample.length;i++){
            //here we are making prefix subarray
            xr = xr ^ sample[i];
            //we need to find x= XR ^ K(formaula), we need to check if this present in the hashmap or not
            int x = xr ^ k;
            if(mpp.containsKey(x)){
                //the number of occurance of the x in the hashmap, will decide the possible number of subarrays 
                //This is concept is similar to largest sub array with 0 sum. 
                count+=mpp.get(x);
            }
            //Insert the prefix and it's count into the hashamp 
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return count;
    }
}
