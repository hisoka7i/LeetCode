import java.util.*;
public class ArrayWithGivenSubSetSum {
    int[] answer;
    public int[] recoverArray(int n, int[] sums) {
        List<Integer> output = new ArrayList<>();
        int sum = 0;
        helper_function(n, sums, output, 0, 0);

        return answer == null? new int[]{-1}:answer;
    }
    public void helper_function(int n, int[] sums, List<Integer> output, int sum, int index){
        if (index >= sums.length || sum > n || answer != null)
            return;

        if(sum == n){
            answer =  output.stream().mapToInt(Integer::intValue).toArray();
            return;
        }


        output.add(sums[index]);
        helper_function(n, sums, output, sum+sums[index], index+1);

        //not picking part
        output.remove(sums[index]);
        helper_function(n, sums, output, sum, index+1);
    }
}
