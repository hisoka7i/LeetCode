package LeetcodeStreak.Medium;

import java.util.HashMap;
import java.util.Map;

public class a1358 {
    public int numberOfSubstrings(String s) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        while (end < s.length()) {
            char startLetter = s.charAt(end);

            map.put(startLetter,
                    map.getOrDefault(startLetter, 0) + 1);
            // moving the window to the right
            while (map.size() == 3) {
                char endLetter = s.charAt(start);
                count += s.length() - end;

                map.put(endLetter,
                        map.get(endLetter) - 1);

                if (map.get(endLetter) == 0) {
                    map.remove(endLetter);
                }
                start++;
            }
            end++;
        }
        return count;
    }

}
