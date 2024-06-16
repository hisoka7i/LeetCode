package HashTable.PracticeProblems;

import java.util.Arrays;

class MyHashSet {
    private boolean[] map;
    public MyHashSet() {
        map = new boolean[1000001];
        Arrays.fill(map, false);
    }
    
    public void add(int key) {
        map[key] = true;
    }
    
    public void remove(int key) {
        map[key] = false;
    }
    
    public boolean contains(int key) {
        return map[key];
    }
}
