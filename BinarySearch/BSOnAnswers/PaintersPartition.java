public class PaintersPartition {
    public static void main(String[] args) {
        
    }
    //This is exactly the same problem as AllocateBooks, SplitArray min(max)
    public static int painterCount(int[] arr,int k){
        int low = Integer.MIN_VALUE;
        int high = 0;

        //Finding the range of min and max
        for(int i:arr){
            if(i>low)low=i;
            high+=i;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            int painters = currentPainterCount(arr, mid);
            if(painters>k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static int currentPainterCount(int[] arr, int max){
        int painter= 1;
        long currentPainter = 0;
        for(int i:arr){
            if(currentPainter + i<=max){
                currentPainter += i;
            }else{
                painter++;
                currentPainter = i;
            }
        }
        return painter;
    }
}
