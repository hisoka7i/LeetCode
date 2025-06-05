public class a2929 {
    public long distributeCandies(int n, int limit) {
        //makig
        long answer = 0;
        for(int i=0;i<=Math.min(limit,n);i++){
            if ( n - i > 2 * limit){ //this means that remaining 2 will get sufficient resources there is no need to check
                continue;
            }
            answer += Math.min(n - i, limit) - Math.max(0 , n - i -limit) + 1;
        }
        return answer;
    }
}
