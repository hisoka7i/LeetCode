package StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class a735 {
    public static void main(String[] args) {
        int[] asteriod = {5,10,-5};
        asteroidCollision(asteriod);
    }
    //asteriod collision
    public static int[] asteroidCollision(int[] asteroid) {
        Stack<Integer> asteriods = new Stack<>();

        for(int a: asteroid){
            if(a>0){
                //if asteroid is moving right we will simply add it
                asteriods.push(a);
            }else{
                while(!asteriods.isEmpty() && asteriods.peek()>0 && asteriods.peek() < -a){
                    asteriods.pop();
                }
                
                if(asteriods.isEmpty() || asteriods.peek()<0){
                    asteriods.push(a);
                }
            
                if(asteriods.peek() == -a){
                    asteriods.pop();
                }
            }
        }

        int[] result = new int[asteriods.size()];
        int n = asteriods.size()-1;
        while (!asteriods.isEmpty()) {
            result[n--]=asteriods.pop();
        }
        return result;
    }
}
