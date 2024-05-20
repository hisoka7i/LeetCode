public class IsSorted {
    public static void main(String[] args) {
        int[] sample = {1,3,3,4,5};
        System.out.println(checkSorted(sample, 0));
    }
    public static boolean checkSorted(int[] arr, int index){
        //base condition
        if(index == arr.length-1){
            return true;
        }
        return arr[index]<=arr[index+1]&&checkSorted(arr, index+1);
    }
}
