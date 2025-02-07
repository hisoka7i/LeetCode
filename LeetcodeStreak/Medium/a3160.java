package LeetcodeStreak.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a3160 {
    public static void main(String[] args) {
        int limit = 6; // Assuming a limit, adjust as necessary
        int[][] queries = {
            {0, 1},
            {0, 4},
            {1, 2},
            {1, 5},
            {1, 4}
        };
        // queryResults(limit,queries);
    }
    public int[] queryResults(int limit, int[][] queries){
        int[] result = new int[queries.length];

        //Hashmap for colors
        Map<Integer,Integer> ballMap = new HashMap<>();
        //Color map, to count
        Map<Integer,Integer> colorMap = new HashMap<>();

        for(int i=0;i<queries.length;i++){
            int ball = queries[i][0];
            int color = queries[i][1];

            //if ball hasColor
            if(ballMap.containsKey(ball)){
                //this means we have a color
                int prevColor = ballMap.get(ball);
                if(colorMap.get(prevColor) == 1){
                    //this is means there is only 1 ball with color, remove that color
                    colorMap.remove(prevColor);
                }else{
                    //this means there are more that one ball with that color
                    colorMap.put(prevColor, colorMap.get(prevColor)-1);
                }
                // ballMap.remove(ball);
            }
            //make a entry for ball and color
            ballMap.put(ball,color);
            colorMap.put(color, colorMap.getOrDefault(color, 0)+1);

            result[i] = colorMap.size();
        }
        return result;
    }
    public static int[] queryResults3(int limit, int[][] queries) {
        int[] result = new int[queries.length];

        //A hashmap to contain, ball and their color after every query
        Map<Integer,Integer> hashtable = new HashMap<>();
        //we need to find unique, colors
        Set<Integer> uniqueColors = new HashSet<>();
        //we need to find unique, colors
        Set<Integer> uniqueBalls = new HashSet<>();
        for(int i=0;i<queries.length;i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            
            if(uniqueBalls.contains(ball)){
                //this means that the ball exist, 
                //now check if the color exist
                if(!uniqueColors.contains(color)){
                    //this means that the color does not exist
                    uniqueColors.remove(hashtable.get(ball));
                }else{

                }
            }
                hashtable.put(ball, color);
                uniqueColors.add(color);
                uniqueBalls.add(ball);
                
                
                result[i] = uniqueColors.size();
        }
       
        return result;
    }



    //This is throwing time limit exceeded for last 5 test casese
    public static int[] queryResults2(int limit, int[][] queries) {
        int[] result = new int[queries.length];

        //A hashmap to contain, ball and their color after every query
        Map<Integer,Integer> hashtable = new HashMap<>();
        //we need to find unique, colors
        for(int i=0;i<queries.length;i++){
            hashtable.put(queries[i][0], queries[i][1]);
            result[i] = uniqueColors(hashtable);
        }
        System.out.println(Arrays.asList(result).toString());
        return result;
    }

    public static int uniqueColors(Map<Integer, Integer> ballsColors){
        Set<Integer> unique_colors = new HashSet<>();
        ballsColors.forEach((key,color)->{
            unique_colors.add(color);
        });
        return unique_colors.size();
    }
}
