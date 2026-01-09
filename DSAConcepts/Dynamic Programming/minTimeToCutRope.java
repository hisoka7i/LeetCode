package DSAConcepts.DynamicProgramming.Tabulation;

public class minTimeToCutRope {
    public static void main(String[] args) {
        minTimeToCutRope ms = new minTimeToCutRope();
        String sample = "aabaa";
        int[] time = {1,2,3,4,1};
        System.out.println(ms.minCost(sample, time));
    }
    public int minCost(String colors, int[] neededTime) {
        int count = 0;
        int i = 0;
        while(i < colors.length() - 1){
            int j = i + 1;
            int max = neededTime[i];
            int group_sum = neededTime[i];
            while(j < colors.length() && colors.charAt(i) == colors.charAt(j)){
                max = Math.max(max, neededTime[j]);
                group_sum += neededTime[j];
                j++;
            }
            if( j - i >= 2)
                count += group_sum - max;
            i = j;
        }
        return count;
    }
}
