package LeetcodeStreak.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a1823 {
    public static void main(String[] args) {
        findTheWinner(5, 2);
    }
    public static int findTheWinner(int n, int k) {
        List<Integer> friends_circle = new ArrayList<>();
        //adding data inside the linked_list
        for(int i=1;i<=n;i++){
            friends_circle.add(i);
        } 
        int current_friend = 0;
        while(friends_circle.size() > 1){
            int next_to_remove = (current_friend + k - 1)%friends_circle.size();
            friends_circle.remove(next_to_remove);
            //changing the index 
            current_friend = next_to_remove;
        }
        return friends_circle.get(0);
    }
}
