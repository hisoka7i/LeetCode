public class a151 {
    public static String reverseWords(String s) {
        //make array of string, this plus will also include multiple spaces
        //this is a regex
        String[] strArray = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i=strArray.length-1;i>=0;i--){
            sb.append(strArray[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
