package LeetcodeStreak.Medium;

public class a769 {
    //In this we will find, break points
    //In a chunk, notice that next chunk will contain next greater element
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int chunks = 0, maxElement = 0;

            for(int i = 0; i<n ; i++){
                maxElement = Math.max(maxElement, arr[i]); 
                //in the range of [0,i] we are checking if there is a break point
                if(maxElement == i){
                    // All values in range [0, i] belong to the prefix arr[0:i]; a new chunk can be formed
                    chunks++;
                }
            }
            return  chunks;
        }
}
