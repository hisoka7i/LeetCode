public class a1539 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
        findKthPositive(arr, k);
    }

    //my solution using array
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int[] hashTable = new int[arr[n-1]+k+1];

        for(int i=0;i<n;i++){
            hashTable[arr[i]-1]=1;
        }
        int count = 0;
        for(int i=0;i<hashTable.length;i++){
            if(count==k)return i;
            if(hashTable[i]==0){
                count++;
            }
        }
        return count+1;
    }

    //Striever solution using binary search
    //Here the intution is to find the range in which that missing number will lie
    //2,3,4,7,11,--> isme index 1 pe 2 hai means ki (2-1) i.e., 1 number missing h,
    //index 4 pr 7 hai means ki (7-4) here 3 numbers missing hai
    public static int missingK(int[] vec, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //missing is number of missing numbers
            int missing = vec[mid] - (mid + 1);
            if (missing < k) {
                //removing the lower half 
                low = mid + 1;
            } else {
                //removing the higher half
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
}
