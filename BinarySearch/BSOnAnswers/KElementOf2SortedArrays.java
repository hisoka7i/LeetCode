import java.util.ArrayList;

public class KElementOf2SortedArrays {
    public static int kthElement(int[] a, int[] b, int n, int m, int k) {
        // Write your coder here
        if(n<m)return kthElement(b, a, m, n, k);

        int low = Math.max(0, m-k);
        int high = Math.min(k, n);

        //length of the left half 
        int left = k;

        while(low<=high){
            int mid1 = low + (high-low)/2;
            int mid2 = k - mid1;

            int l1 = mid1==0?Integer.MIN_VALUE:a[mid1-1];
            int l2 = mid2==0?Integer.MIN_VALUE:b[mid1-1];
            int r1 = mid1==n?Integer.MAX_VALUE:a[mid1];
            int r2 = mid2==m?Integer.MAX_VALUE:b[mid2];

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1; 
            }
        }
        return 0;
    }
}
