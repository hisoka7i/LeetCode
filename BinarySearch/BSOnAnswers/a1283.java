public class a1283 {
    public static void main(String[] args) {
        int[] sample = {44,22,33,11,1};
        System.out.println(binarySearch(sample, 5));
    } 
    //It's a good thing that now I am able to get some pattern dediction, in binary search
    public static int binarySearch(int[] sample,int k){
        int low = 1;
        int high = Integer.MAX_VALUE;
        for(int i:sample){
            high = Math.max(i, high);
        }
        while (low<=high) { 
            int mid = low + (high-low)/2;
            if(thresholdCheck(sample, mid, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static boolean thresholdCheck(int[] sample,int m,int k){
        int count = 0;
        for(int i:sample){
            count += Math.ceil((double)i/(double)m);
            if(count>k)return false;
        }
        if(count>k)return false;
        return true;
    }
}
