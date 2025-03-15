package LeetcodeStreak.Medium;

public class a3208 {
    public static void main(String[] args) {
        a3208 a3208 = new a3208();
        a3208.numberOfAlternatingGroups(new int[]{0,1,0,1,0}, 3);
    }


    
    public int numberOfAlternatingGroups2(int[] colors, int k) {
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

    private int numberOfAlternatingGroups(int[] i, int k) {
        int[] extendedAray = new int[i.length + k -1];
        for(int j=0;j<i.length;j++){
            extendedAray[j] = i[j];
        }
        for(int j=0;j<k-1;j++){
            extendedAray[i.length+j] = i[j];
        }
        int length = extendedAray.length;
        int result = 0;
        int left = 0;
        int right = 1;
        while(right < length){
            if(extendedAray[right] == extendedAray[right-1]){
                left = right;
                right++;
                continue;
            }
            right++;
            if(right - left < k)continue;

            result++;
            left++;
        }
        return result;
    }
}
