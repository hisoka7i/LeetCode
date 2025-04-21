package LeetcodeStreak.Medium.PrefixSum;

public class a2145 {
    int count = 0;
    public int numberOfArrays(int[] differences, int lower, int upper) {
        if(differences.length == 0){
            return  -1;
        }

        
        
        findArray(differences, lower, upper, 0);
        return count;
        //we need to find all the pairs who satisfies the first condition and then we simply need to add the values of difference array
    }

    public void findArray(int[] differences, int lower, int upper, int index){
        int n = differences.length;
        if(lower+index == upper){
            return;
        }

        int first_value = lower + index;

        for(int i = 0; i < n ; i++){
            int next_value = first_value + differences[i];
            if(lower <= next_value  && next_value <= upper){
                //this means it is within the range
                first_value = next_value;
            }else{
                findArray(differences, lower, upper, index+1);
                return; //move to the next value
            }
        }
        count++;
        findArray(differences, lower, upper, index+1); //this means that it worked without fail
    }
}
