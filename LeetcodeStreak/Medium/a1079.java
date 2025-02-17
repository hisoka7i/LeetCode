package LeetcodeStreak.Medium;

import java.util.HashSet;
import java.util.Set;

public class a1079 {
    public int numTilePossibilities(String tiles) {
        Set<String> sequences = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        generatePermutations(tiles, "", used, sequences);
        return sequences.size()-1;
    }

    public void generatePermutations(String tiles, String current, boolean[] used, Set<String> sequences){
        sequences.add(current); //adding the current sequence
        int len = tiles.length();

        for(int pos = 0; pos<len; pos++){
            if(!used[pos]){
                used[pos] = true;
                generatePermutations(tiles, current+tiles.charAt(pos), used, sequences);
            }
            used[pos] = false;
        }
    }

    //this is correct thinking but it is wrong implementation
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
