public class MinMaxGasStation {
    //In this question we are simply trying the minimize the maximum distance between 2 stations, 
    //by putting new stations between them 

    //in this question we make sections, (sections basically means distance b/w 2 stations)
    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            //This will give the number of stations in a section
            int numberInBetween = (int)((arr[i]-arr[i-1])/dist);
            if((arr[i]-arr[i-1]==(dist*numberInBetween))){
                numberInBetween--;
            }
            cnt+=numberInBetween;
        }
        return cnt;
    }
    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        double low = 0;
        double high = 0;

        //find the maximum distance 
        for(int i=0;i<n;i++){
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }


        double diff = 1e-6;
        //here we will not be using low<=high, since the values are in double and comparison will take a lot of time
        while(high-low>diff){
            double mid = (high-low)/2.0;
            if(numberOfGasStationsRequired(mid, arr)>k){
                //that means numbers of gas stations required is much more than provided, 
                //so we will negate the left half 
                low = mid;
            }else{
                high = mid;
            }
        }
        return high;
    }
}
