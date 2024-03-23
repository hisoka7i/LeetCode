class AgressiveCows{
    public static void main(String[] args) {
        
    }
    //This pattern is of min of max
    public static boolean canWePlace(int[] arr,int dis,int cows){
        int countCow = 1, lastCow = arr[0]; //position of last placed cow
        for(int i=0;i<arr.length;i++){
            //we are checking here weather we can place the cow, there or not by checking the distance
            if((arr[i]-lastCow)>=dis){
                countCow++; //updating the count of the cows that we can place
                lastCow = arr[i]; //updating the last location
            }
            //the moment we get to the number of cows that we need to place we will return true
            if(countCow>=cows){
                return true;
            }
        }        
        return false;
    }
    public static int aggressCow(int[] stalls, int k){
        int n = stalls.length;
        Arrays.sort(stalls);

        int limit = stalls[n-1] - stalls[0];
        for(int i=1;i<= limit; i++){
            if(canWePlace(stalls,i,k)==false){
                return(i-1);
            }
        }
        return limit;
    }
}