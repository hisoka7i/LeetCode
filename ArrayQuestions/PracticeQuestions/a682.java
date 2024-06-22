package ArrayQuestions.PracticeQuestions;

import java.util.ArrayList;
import java.util.List;

public class a682 {
    public static void main(String[] args) {
        
    }
    public static int calPoints(String[] operations) {
        //this is my solution, there is better solution 
        //which will use array of size of operations
        List<Integer> final_list = new ArrayList<>();
        for(String current_item: operations){
            if(current_item.equals("D")){
                final_list.add(final_list.get(final_list.size()-1)*2);
            }else if(current_item.equals("C")){
                final_list.remove(final_list.get(final_list.size()-1));
            }else if(current_item.equals("+")){
                final_list.add(final_list.get(final_list.size()-1)+final_list.get(final_list.size()-2));
            }else{
                final_list.add(Integer.valueOf(current_item));
            }
        }
        int final_value = 0;
        for(Integer current_value: final_list){
            final_value += current_value;
        }
        return final_value;
    }
}
