public class a4 {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        //I always want a to be smaller than b
        if(n1>n2)return findMedianSortedArrays(b,a);

        int n = n1 + n2;

        //length of the left half
        int left = (n1 + n2 + 1)/2;
        //we will always do binary search on the smaller array
        int low = 0;
        int high = n1;
        while(low<=high){
            int mid1 = low + (high-low)/2;
            int mid2 = left - mid1;

            //calculate l1, l2, r1 and r2;
            //In min_value we will take in case if there is no value on l1,l2
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                //In case of odd, we will take higher value which is present on the left side
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }
}
