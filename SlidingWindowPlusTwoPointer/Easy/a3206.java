package Easy;

public class a3206 {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;
        for(int i=0;i<n;i++){
            if(isAlternating(colors, i, 3)){
                count++;
            }
        }
        return  count;
    }
    public boolean isAlternating(int[] colors, int p, int k){
        int n = colors.length;
        int prev = colors[p%n];
        while(k-1 > 0){
            int current = colors[(p+1)%n];
            if(prev == current)return  false;
            prev = current;
            p = p+1;
            k--;
        }
        return true;
    }
}
