package ArrayQuestions.PracticeQuestions;
import java.util.*;

import javax.sound.sampled.EnumControl.Type;
import javax.swing.RowFilter.Entry;
public class a925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex","aaleexa"));
    }
    public static boolean isLongPressedName(String name, String typed){
        int ptr1 = 0, ptr2 = 0;
        while(ptr1<name.length()){
            if(ptr2>typed.length()-1)return false;
            if(name.charAt(ptr1)==typed.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }else{
                if(ptr1==0)return false;
                if(typed.charAt(ptr2-1)==typed.charAt(ptr2)){
                    ptr2++;
                    continue;
                }else{
                    return false;
                }
            }
        }
        System.out.println(typed.charAt(ptr2));
        if(ptr2==typed.length()-1)
            if(name.charAt(ptr1-1)!=typed.charAt(ptr2))return false;
        while(ptr2<typed.length()-1){
            if(typed.charAt(ptr2+1)!=typed.charAt(ptr2)){
                return false;
            }
            ptr2++;
        }
        return true;
           }
}
