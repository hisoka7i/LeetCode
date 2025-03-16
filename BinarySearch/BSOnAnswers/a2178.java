

public class a2178 {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1;
        long r = 100000000000001L;
        long minTime = -1;
        while(l<r){
            long mid = l + (r-l)/2;
            if(trips(time, mid) >= totalTrips){
                minTime = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return minTime;
    }
    public long trips(int[] time, long avgtime){
        long tTrips = 0;
        for(int ct: time){
            tTrips += avgtime/ct;
        }
        return tTrips;
    }
}
