public class a3042 {
    public static void main(String[] args) {
        String[] sample = {"a","aba","ababa","aa"};
        System.out.println(countPrefixSuffixPairs(sample));
    }
    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j){
                    if(isPrefixAndSuffix(words[i], words[j]))count++;
                }
            }
        }
        return count;
    }
    public static boolean isPrefixAndSuffix(String str1,String str2){
        if(str1.length()<str2.length()){
            
            if(!str1.equals(str2.substring(str1.length()-1)))return false;
            if(!str1.equals(str2.substring(0,str1.length())))return false;
            return true;
        }
        return false;
    }
}
