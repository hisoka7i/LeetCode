import java.util.*;

public class a49 {
    static List<List<String>> output = new ArrayList<>();
    static List<String> sampleList = null;
    public static void main(String[] args) {
        String cat = "cat";
        String[] sample = {"eat","tea","tan","ate","nat","bat"};
        sampleList = Arrays.asList(sample);
        Map<String,List<Integer>> filledMap = fillMap(sampleList);
        
        List<List<String>> output = new ArrayList<>();
        for(Map.Entry<String,List<Integer>> map: filledMap.entrySet()){
            List<Integer> positions = map.getValue();
            List<String> groupanagrams = new ArrayList<>();
            for(Integer i: positions){
                groupanagrams.add(sampleList.get(i));
            }
            output.add(groupanagrams);
        }
        System.out.println(output);
    }
    public static Map<String,List<Integer>> fillMap(List<String> sample){
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i=0;i<sample.size();i++){
            char[] ch = sample.get(i).toCharArray();
            Arrays.sort(ch);
            String currentSortedString = String.valueOf(ch);
            if(!map.containsKey(currentSortedString)){
                List<Integer> pos = new ArrayList<>();
                map.put(currentSortedString, pos);
            }
            List<Integer> pos = map.get(currentSortedString);
            pos.add(i);
            map.put(currentSortedString, pos);
        }
        return map;
    }
}
