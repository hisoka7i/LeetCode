public class Kargs{
  int[] a;
  public Kargs(int n){
    a = new int[n];
  }
  public void possiblities(int n, int k){
    if(n<=0){
      for(int i:a){
        System.out.print(i);
      }System.out.println();
    }else{
      for(int j=0;j<k;j++){
        a[n-1]=j;
        possiblities(n-1,k);
      }
    }
  }
  public static void main(String[] args){
    int n = 4;
    Kargs test = new Kargs(n);
    test.possiblities(n,3);
  }

}
