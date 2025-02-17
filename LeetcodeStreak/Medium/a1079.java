package LeetcodeStreak.Medium;

import java.util.HashSet;
import java.util.Set;

public class a1079 {
    public int numTilePossibilities(String tiles) {
        Set<String> toremoveDuplicates = new HashSet<>();
        for (int i = 0; i < tiles.length(); i++) {
            String sample = tiles.substring(i);
            inOrderPermutations("", sample, toremoveDuplicates);
        }
        
        return toremoveDuplicates.size();
    }

    private void inOrderPermutations(String prefix, String sample, Set<String> toremoveDuplicates) {
        // TODO Auto-generated method stub
        int length = sample.length();
        if(length == 0){
            toremoveDuplicates.add(prefix);
        }else{
            for(int i=0;i<length;i++)
                inOrderPermutations(prefix+sample.charAt(i), sample.substring(0, i) + sample.substring(i+1, length), toremoveDuplicates);
        }
    }

}
