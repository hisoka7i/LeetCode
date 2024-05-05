package String.Medium;
class a1781{
    public static void main(String[] args) {
        System.out.println(">>>>>>>"+beautySum("aabcb"));
    }
    public static int beautySum(String s) {
        int finalSum = 0;
        for(int i=0;i<s.length();i++){
            //we are taking count of all the substrings into the trie
            int[] trie = new int[26];
            //here we are finding all the substrings
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                trie[ch-'a']++;
                //we calculating the beauty of all the sub-strings into the final sum
                finalSum += beautyCalc(trie); 
            }
        }
        return finalSum;
    }
    //This is a function to calculate all the beauty
    public static int beautyCalc(int[] trie){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int k=0;k<trie.length;k++){
            max = Math.max(max, trie[k]);
            if(trie[k]>=1){
                min = Math.min(min, trie[k]);
            }
        }
        return max-min;
    }
}