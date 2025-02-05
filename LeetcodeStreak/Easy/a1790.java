package LeetcodeStreak.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a1790 {
    // This is only failing 2/138 test cases
    public boolean areAlmostEqual2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int count = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2)
                    return false;
                if (count == 1) {
                    firstIndex = i;
                } else {
                    secondIndex = i;
                }
            }
        }

        return ((s1.charAt(firstIndex) == s2.charAt(secondIndex) && (s2.charAt(secondIndex) == s1.charAt(firstIndex))));
    }
}
