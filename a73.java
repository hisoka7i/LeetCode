public class a73 {
    //optimized way of doing sample conversion 
    //time complexity n^2 and space complexity O(m)
    public void setsampleZero(int[][] sample,int n,int m){
        //taking row[0] as a hashtable to keep track of zeros
        //taking col[0] as a hashtable to keep track of zeros 
        //at 0 index there is a collision so we will not using col[0][0] instead we will use another variable
        int col0 = 1;
        int m = sample[0].length;
        int n = sample.length;
        for(int i=0;i<n;i++){ //this is to mark the col0 and row0
            for(int j=0;j<m;j++){
                if(sample[i][j]==0){
                    sample[i][0]=0;
                    if(j!=0)
                        sample[0][j]=0;
                    else
                        col0=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(sample[i][j]!=0)
                    if(sample[0][j]==0 || sample[i][0]==0){
                        sample[i][j]=0;
                    }
            }
        }
        if(sample[0][0]==0){
            for(int i=0;i<m;i++){
                sample[0][i]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<n;i++){
                sample[i][0]=0;
            }
        }
}
