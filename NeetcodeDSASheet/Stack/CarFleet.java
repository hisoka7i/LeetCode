package NeetcodeDSASheet.Stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed){
        int n = position.length;
        int[][] car = new int[n][2]; //this is to store position and speed

        for(int i=0;i<n;i++){
            car[i][0] = position[i]; //this is store position
            car[i][1] = speed[i]; 
        }

        //sort the pair according to based position (Descending)
        Arrays.sort(car, (a,b)->Double.compare(b[0], a[0]));

        int fleets = 0;
        double lastFleettime = 0;
        //A fleet is formed when a slower car ahead prevents a faster car behind from overtaking it. This happens when they have the same or larger time to reach the target.
        for(int i=0;i<n;i++){
            Double time = (double) ((target - car[i][0])/car[i][1]); 
            if(time > lastFleettime){
                fleets++;
                lastFleettime = time;
            }
        }

        return fleets;
    }
    /*
     * This solution is wrong this does not consider speed, in it calculation
    */
    public int carFleet2(int target, int[] position, int[] speed) {
     //create a function which will change position of every car with time
     //function will end once all the car reach the target
     //count number of fleets at time 0;
     int[] positions  = new int[target+1]; //lst one is to mark number of cars reached the target
     for(int currentPos: position){
        positions[currentPos] = positions[currentPos]+1;
     }
     int cars = position.length;
     int carFleet = 0;
     while(cars > 0){
        //every loop will be considered 1 second that has passed
        //first counting the car fleets that has reached the target
        carFleet += positions[target];
        //making the last position empty
        positions[positions.length - 1] = 0;

        //now need to update all the car positions
        for(int i=0; i<position.length; i++){
            //need to update the positions
            int new_position = position[i] + speed[i];
            position[i] = new_position;
            if(new_position < positions.length){
                positions[new_position - 1] += 1;
                //need to update speed here.
                if(positions[new_position - 1]>1){
                    speed[new_position] = 0;
                }
            }else{
                //means car reached the target
                positions[target] += 1;
            }
        }
        cars -= positions[target];
     }

     return carFleet==0?0:carFleet-1;
    }
}
