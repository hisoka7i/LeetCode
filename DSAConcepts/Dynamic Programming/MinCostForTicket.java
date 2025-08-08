import java.util.Arrays;

public class MinCostForTicket {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length + 1];
        Arrays.fill(memo , -1);
        return helper_function_memo(days, costs, 0, memo);
    }
    public int helper_function(int[] days, int[] cost, int i){
        if(i >= days.length){
            return 0; //this means that we have covered all the days of travelling
        }

        int day_cost = cost[0] + helper_function(days, cost, i + 1); // this means travelling for a day

        int j = i;
        while( j < days.length && days[j] < days[i] + 7)j++;
        int week_cost = cost[1] + helper_function(days, cost, j);

        int k = i;
        while( k < days.length && days[k] < days[i] + 30)k++;
        int month_cost = cost[2] + helper_function(days, cost, k);

        return Math.min(day_cost, Math.min(week_cost, month_cost));
    }

    public int helper_function_memo(int[] days, int[] cost, int i, int[] memo){
        if( i >= days.length)return 0;
        if(memo[i] != -1)return memo[i];
        int day_cost = cost[0] + helper_function_memo(days, cost, i + 1, memo); // this means travelling for a day

        int j = i;
        while( j < days.length && days[j] < days[i] + 7)j++;
        int week_cost = cost[1] + helper_function_memo(days, cost, j, memo);

        int k = i;
        while( k < days.length && days[k] < days[i] + 30)k++;
        int month_cost = cost[2] + helper_function_memo(days, cost, k, memo);

        return memo[i] = Math.min(day_cost, Math.min(week_cost, month_cost));
    }

}
