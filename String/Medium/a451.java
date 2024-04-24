package String.Medium;

import java.util.HashMap;
import java.util.PriorityQueue;


public class a451 {
    public static void main(String[] args) {
        
    }
    //leetcode solution using priority queue
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((x,y)->map.get(y)-map.get(x));
        for(char c: map.keySet()){
            queue.offer(c);
        }
        while(!queue.isEmpty()){
            char ch = queue.poll();
            for(int i=0;i<map.get(ch);i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    //mysolution was to make a trie and then add, values into it
    //Then make a Node and add character nodes into it according to count
    public static String frequencySort1(String s){
        String outString="";
        int[] trie = new int[26];
        for(int i=0;i<s.length();i++){
            trie[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(trie[i]!=0){
                
            }
        }
        return outString;
    }
    public void insertNode(StringNode node,char ch,int count){
        StringNode temp = node;
        if(temp==null){
            StringNode newNode = new StringNode(ch,count);
            node = newNode;
        }
        while(temp!=null){
            if(temp.next==null){
                if(temp.count>count){
                    temp.next = temp;
                }else{
                    StringNode newHead = new StringNode(ch, count);
                    newHead.next = temp;
                    node = newHead;
                }
            }
            else{
                if(temp.next.count<count){
                    StringNode newNode = new StringNode(ch, count);
                    if(temp.next.next==null){
                        temp.next =newNode;
                    }else{
                        newNode.next = temp.next.next;
                        temp.next = newNode;
                    }
                }else if(temp.count<count){
                    StringNode newNode = new StringNode(ch, count);
                    newNode.next = temp;
                    node = newNode;
                }
            }
        }
    }
}
class StringNode{
    char ch;
    int count;
    StringNode next;
    StringNode(char ch,int count){
        this.ch=ch;
        this.count=count;
    }
}