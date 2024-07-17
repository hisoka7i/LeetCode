package String.Medium;

public class a1910{
    public static void main(String[] args) {
        
    }
    //Intution
    //we will simply get the string and remove the part in a for loop..
    public static String removeOccurrences(String s, String part) {
        StringBuilder string_builder = new StringBuilder(s);
        while(string_builder.indexOf(part)!=-1){
            //we are getting the index of part of string 
            int index = string_builder.indexOf(part);
            string_builder.delete(index, index+part.length());
        }
        return string_builder.toString();
    }
}