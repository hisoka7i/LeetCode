package String;
import java.util.*;

public class a49 {
    static List<String> sampleList = null;
    public static void main(String[] args) {
        String cat = "cat";
        String[] sample = {"eat","tea","tan","ate","nat","bat"};
        sampleList = Arrays.asList(sample);
        Map<String,List<String>> filledMap = fillMap(sampleList);
        System.out.println(new ArrayList<>(filledMap.values()));
    }
    public static Map<String,List<String>> fillMap(List<String> sample){
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<sample.size();i++){
            char[] ch = sample.get(i).toCharArray();
            Arrays.sort(ch);
            String currentSortedString = String.valueOf(ch);
            if(!map.containsKey(currentSortedString)){
                List<String> pos = new ArrayList<>();
                map.put(currentSortedString, pos);
            }
            List<String> pos = map.get(currentSortedString);
            pos.add(sample.get(i));
            map.put(currentSortedString, pos);
        }
        return map;
    }
}
