package ArrayQuestions.Concepts;
import java.util.ArrayList;
import java.util.List;

public class ReversePair {

    //This will be done be merge sort
    private static void merge(int[] arr, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int left = low; //starting index for left half
        int right = mid + 1; //starting index for right half 

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }

        //for the remaining elements 
        if(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        if(right<=high){
            temp.add(arr[right]);
            right++;
        }

        //adding sorted elements back to the array 
        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
    }

    static int countPairs(int[] arr,int low,int mid,int high){
        int right = mid + 1;
        int count = 0;
        for(int i=low;i<=mid;i++){
            while(right<=high && arr[i]<2*arr[right]) right++;
            count += (right - (mid+1));
        }
        return count;
    }
    static int mergeSort(int[] arr, int low, int high){
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += countPairs(arr, low, mid, high); //Modification
        merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }
    public static int team(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }
     public static void main(String[] args) {
        int[] a = {1,3,2,3,1};
        int n = a.length;
        int cnt = team(a, n);
        System.out.println("The number of reverse pair is: " + cnt);
    }
}
