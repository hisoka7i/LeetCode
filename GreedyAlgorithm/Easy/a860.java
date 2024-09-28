package GreedyAlgorithm.Easy;

import java.util.Arrays;
 
public class a860 {
    public boolean lemonadeChange(int[] bills) {
        int number_of_five = 0;
        int number_of_ten = 0;
        // Arrays.sort(bills); This line will not be used since there are people in queue, at current time

        for(int current_bill: bills){
            if(current_bill == 5){
                number_of_five += 1;
            }
            if(current_bill == 10){
                if(number_of_five > 0){
                    number_of_five -= 1;
                    number_of_ten += 1;
                }else{
                    return false;
                }
            }
            if(current_bill == 20){
                if(number_of_ten > 0 && number_of_five >0){
                    number_of_five -= 1;
                    number_of_ten -= 1;
                }else if(number_of_five > 2){
                    number_of_five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
