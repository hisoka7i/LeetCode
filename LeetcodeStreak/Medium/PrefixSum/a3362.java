package LeetcodeStreak.Medium.PrefixSum;

import java.util.*;
import java.util.PriorityQueue;

public class a3362 {
    public static void main(String[] args) {
        a3362 obj = new a3362();
        int[] nums = {1, 1,1,1};
        //[[1,3],[0,2],[1,3],[1,2]] make queries using this
        int[][] queries = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
        System.out.println(obj.maxRemoval(nums, queries)); // Output: 3
    }
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a,b) -> Integer.compare(a[0], b[0]));

        int diff[] = new int[nums.length + 1];
        int operations = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0,j=0;i<nums.length;i++){
            operations += diff[i];
            for(;j<queries.length && queries[j][0] == i;j++){
                pq.add(queries[j][1]);
            }
        while(operations < nums[i] && !pq.isEmpty() && pq.peek() >= i){
            operations++;
            diff[pq.poll()+1]--;
        }
        if(operations < nums[i]){
            return -1;
        }
        }
        return pq.size();
    }
    public int maxRemovalNotWorking(int[] nums, int[][] queries) {
        //making the diff array
        int n = nums.length;
        int[] diff = new int[n + 1];

        // We need to greedily pick the queries with farthest ending point first.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[1], a[1]);
            }
        });

        //now adding the queries to the queue
        for(int i=0;i<queries.length;i++){
            pq.add(new int[]{queries[i][0],queries[i][1]});
        }

         
        //now one by one we will take the queries and check if we can make nums a zero array
        while(!pq.isEmpty()){
            int[] query = pq.poll();
            int start = query[0];
            int end = query[1];
            System.out.println(start + ".()" + end);
            //adding the values to the diff array
            diff[start]++;
            diff[end + 1]--;

           
            //make a temp array copy of the diff array
            int[] temp = new int[n + 1];
            System.arraycopy(diff, 0, temp, 0, diff.length);

            for(int i=1;i<temp.length;i++){
                temp[i] += temp[i - 1];
            }
            //checking if every element of prefix sum array is greater than or equal to that of nums
            boolean flag = true;
            for(int i=0;i<nums.length;i++){
                if(temp[i] < nums[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
            
        }
        return pq.size()==0 ? -1 : pq.size() ;
    }
}
