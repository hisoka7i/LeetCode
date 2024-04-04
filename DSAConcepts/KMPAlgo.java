
public class KMPAlgo<F> {
   int F[];
   public void prefixTable(char P[], int m){
    int i=1,j=0;
    F[0]=0;
    while(i<m){
        if(P[i]==P[j]){
            F[i]=j+1;
            i++;
            j++;
        }else if(j>0){
            j = F[j-1];
        }else{
            F[i]=0;
            i++;
        }
    }
   }
   public KMPAlgo(int m){
    F = new int[m];
   }

   public int KMPTest(char T[], int n, char P[], int m){
    int i=0,j=0;
    prefixTable(P, m);
    while (i<n) {
        if(P[j]==T[i]){
            if(j==(m-1)){
                return i-j;
            }else{
                i++;
                j++;
            }
        }else if(j>0){
            j=F[j-1];
        }else{
            i++;
        }
        
    }
    return -1;
   }
   public static void main(String[] args) {
    
    String pattern = "ab";
    String sample = "bacbabababacaca";
    KMPAlgo testAlgo = new KMPAlgo(pattern.length());

    System.out.println(testAlgo.KMPTest(sample.toCharArray(), sample.length(), pattern.toCharArray(), pattern.length()));
   } 
}
