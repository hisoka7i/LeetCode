package ArrayQuestions.MediumPractice;

public class a1109 {
    //Co operate flight booking 
    /*
     * difference array technique or prefix sum technique. 
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //we will be making a prefix sum array 
        int []result = new int[n];

        //now we will iterate through the bookings
        for(int[] book: bookings){
            //setting the initial value in thte prefix array
            result[book[0] - 1] += book[2];
            //setting the ending value for the prefix array 
            if(book[1]<n){
                result[book[1]] -= book[2];
            }
        }

        //now adding in the prefix array
        for(int i=1;i<n;i++){
            result[i] += result[i-1];
        }
        return result;
    }
}
