import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class a56 {
    public static void main(String[] args) {
        
    }

    //brute force solution
    public static int[][] mergeThem(int[][] merge){
        Arrays.sort(merge, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> output = new ArrayList<>();
        for(int i=0;i<merge.length;i++){
            int start = merge[i][0];
            int end = merge[i][1];
            //If the interval given in the sample array is present in the interval, included in the output then simply skip
            if(!output.isEmpty() && end<=output.get(output.size()-1)[1]){
                continue;
            }

            for(int j=i+1;j<merge.length;j++){
                //here we are checking which of the end interval is bigger
                if(merge[j][0] <= end){
                    end = Math.max(merge[j][1], end);
                }else{
                    break;
                }
            }
            output.add(new int[]{start,end});
        }
        return output.toArray(new int[output.size()][]);
    }
}
