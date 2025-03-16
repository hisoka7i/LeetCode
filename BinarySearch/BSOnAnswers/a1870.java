

public class a1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = 10_000_000;
        int minSpeed = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(time(dist,mid)<=hour){
                //that means it is a valid answer, and we can search for even lower speeds
                minSpeed = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return minSpeed;
    }
    public double time(int[] dist, int speed){
       double time = 0;
        for(int i=0;i<dist.length-1;i++){
            time += Math.ceil((double)dist[i]/speed);
        }
        time = time + ((double)dist[dist.length-1])/speed;
        return time;
    }
}
