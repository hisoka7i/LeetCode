public class a1011 {
    public static void main(String[] args) {
        int[] sample = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(sample, 5));
    }
    //This is fairly simple solution
    public static boolean checkDay(int[] arr, int m, int k){
        int days = 1;
        int load = 0;
        for(int i:arr){
            if((load + i)>m){
                days+=1; //moving to the next day 
                load = i; //load the weight
            }else{
                load += i; //adding the weight
            }
        }
        if(days<=k)return true;
        return false;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        //setting the value of low and high
        for(int i:weights){
            low = Math.max(i, low);
            high += i;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if(checkDay(weights, mid, days)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
