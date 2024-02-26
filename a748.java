public class a748 {
    public static void main(String[] args) {
        String licString = "aBc 12ca";
        String[] words = {"abccdef", "caaacab"};
        shortestCompletingWord(licString, words);
    }
    public static String shortestCompletingWord(String licensePlate, String[] words){
        int[] licensePlateArray = new int[26];
        String outString=null;
        int shortest = Integer.MAX_VALUE;
        boolean flag = false;
        licensePlate = licensePlate.toLowerCase();
        for(int i=0;i<licensePlate.length();i++){
            if(licensePlate.charAt(i)<='z' && licensePlate.charAt(i)>='a'){
                licensePlateArray[licensePlate.charAt(i)-'a']+=1;
            }
        }
        for(int i=0;i<words.length;i++){
            System.out.println(shortest);
            if(words[i].length()<shortest){
                String currentWord = words[i];
                int[] wordsArray = new int[26];
                int j=0;
                for(j=0;j<currentWord.length();j++){
                    if(currentWord.charAt(j)<='z' && currentWord.charAt(j)>='a'){
                        wordsArray[currentWord.charAt(j)-'a']+=1;
                    }
                }
                for(j=0;j<licensePlate.length();j++){
                    if(licensePlate.charAt(j)<='z' && licensePlate.charAt(j)>='a'){
                        
                       if(licensePlateArray[licensePlate.charAt(j)-'a']>wordsArray[licensePlate.charAt(j)-'a']){
                            break;
                       }
                       System.out.print(licensePlate.charAt(j)+" "+licensePlateArray[licensePlate.charAt(j)-'a']+" ");
                        System.out.println(wordsArray[licensePlate.charAt(j)-'a']);
                    }
                    if(j==licensePlate.length()-1){
                        System.out.println("Working");
                        flag = true;
                        shortest = currentWord.length();
                        outString = currentWord;
                    }
                }
            }else{
                continue;
            }
        }
        System.out.println(outString);
        return outString;
    }
}
