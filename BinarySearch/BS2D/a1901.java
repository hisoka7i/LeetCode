package BinarySearch.BS2D;

public class a1901 {
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int row = maxElement(mat,n,m,mid);
            int left = mid-1>=0?mat[row][mid-1]:-1;
            int right = mid+1<m?mat[row][mid+1]:-1;

            if(mat[row][mid]>left && mat[row][mid]>right)
                return new int[]{row,mid};
            else if(mat[row][high]<left)high=mid-1;
            else low = mid+1;
        }
        return new int[]{-1, -1};
    }
    public static int maxElement(int[][] mat,int n,int m,int col){
        int max =0;
        int row = -1;
        for(int i=0;i<n;i++){
            if (mat[i][col] > max) {
                max = mat[i][col];
                row = i;
            }
        }
        return row;
    }
}
