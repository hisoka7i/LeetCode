package LeetcodeStreak.Medium;
public class a1701 {
    public static void main(String[] args) {
        
    }
    /*
     * Keep track of the time when previous customer finished being served
     * waiting time: end of previous service and the customer's arrival time, plus service time
    */
    public static double averageWaitingTime(int[][] customers) {
        double total_waiting_time = 0;
        int current_time = customers[0][0];
        for(int i=0;i<customers.length;i++){
            int arrival = customers[i][0];
            int service_time = customers[i][1];
            if(current_time < arrival ){
                current_time = arrival;
            }
            int waiting_time = current_time - arrival + service_time; 
            total_waiting_time += waiting_time;
            //this will be for the next customer
            current_time += service_time;
        }
        return (double)total_waiting_time/customers.length;
    }
}
