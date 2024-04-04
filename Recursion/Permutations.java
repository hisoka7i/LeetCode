public class Permutations {
    public static void main(String[] args) {
        inOrderPermutation("", "null");
    }
    public static void inOrderPermutation
    (String prefix, String sample){
        int len = sample.length();
        if(len==0){
            System.out.println(">>>"+prefix);
        }else{
        for(int i=0;i<len;i++){
        inOrderPermutation(prefix+sample.charAt(i), sample.substring(0, i)+sample.substring(i+1, len));
        }
    }
    }
}
