package LeetcodeStreak.Medium;

public class a3208 {
    public static void main(String[] args) {
        a3208 a3208 = new a3208();
        a3208.numberOfAlternatingGroups(new int[]{0,1,0,1,0}, 3);
    }
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        for(int i=0;i<n;i++){
            if(isAlternating(colors, i, k)){
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
