package LeetcodeStreak.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import javax.swing.text.Position;

public class a2751 {
    public static void main(String[] args) {
        
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths,
     String directions) {

        //We need a array of indices
        Integer[] indices  = new Integer[positions.length];

        for(int i=0;i<positions.length;i++){
            indices[i]=i;
        }

        //sorting the indices according to the positions
        Arrays.sort(indices,(a,b)->positions[a]-positions[b]);

        List<Integer> robots = new ArrayList<>();

        for(int i : indices){
            if(directions.charAt(i)=='R'){
                //we will insert all the right moving robots into the array
                robots.add(i);
            }else{
                while(!robots.isEmpty() && healths[i]>0){
                    //This means it is a colliding robot
                   int n = robots.get(robots.size()-1);
                   if(healths[n]>healths[i]){
                    //this means that the right moving robot is stronger then the left moving robot
                    healths[n]--; //reducing the health of right moving robot
                    healths[i]=0; //setting the health of left moving robot as nill
                   }else{
                    //This means that the left moving robot is either 
                    //stronger or equal
                    robots.remove(robots.size()-1); //removing the last robot
                    //this left moving robot will keep on fighting will right moving robot until the end
                    healths[i] -= (healths[i]>healths[n]?1:healths[i]);
                    healths[n]=0; //setting the health of right moving robot as nill
                   }
                }
            }
        }
        return Arrays.stream(healths).filter(h -> h > 0).boxed().collect(Collectors.toList());
        
         
        /*Stack<Map<Integer,Character>> robot_health_stack = new Stack<>();
        for(int i=0;i<directions.length();i++){
            if(robot_health_stack.isEmpty()){
                //we will simply enter the health value in case of empty
                Map<Integer,Character> robot_health_and_direction = new HashMap<>();
                robot_health_and_direction.put(healths[i], directions.charAt(i));
                //adding the data into the map 
                robot_health_stack.push(robot_health_and_direction);
            }else{
                //we need to compare if there is a mismatch of direction
                if(directions.charAt(i)!=robot_health_stack.peek().get(0)){
                    //means there is a mismatch of direction
                    Map<Integer, Character> current_robot = robot_health_stack.pop();

                    int previous_robot_health = current_robot.entrySet(). //get the first key here 
                    int current_robot_health = healths[i];
                    if(previous_robot_health == current_robot_health){
                        //both robots record dies from the stack
                        continue;
                    }else{
                        if()
                    }
                }else{
                    //simply insert into the map 
                }
            }
        }*/
    }
}
