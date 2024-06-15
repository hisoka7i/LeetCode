package StackAndQueue.ImplementationProblems;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    //map key -> Node
    private Map<Integer,Node> cache;
    //map to store the nodes  
    //map to the number of times(freq) they have been used
    private Map<Integer, List> freqMap;
    //globally storing the assigned capacity, current cache size
    // also storing the minimum frequency
    private int capacity, currSize, minFreq;
    public LFUCache(int capacity){
        this.capacity = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public void put(int key,int value){
        if(capacity==0){ //we can not add a key if capacity is zero
            return;
        }
        //if key is already present
        if(cache.containsKey(key)){
            Node node = cache.get(key); //getting the node 
            node.value = value; //updating the value
            updateNode(node); // updating the node frequency and moving it into the next list
        }else{
            //increasing the current size of cache
            currSize++;
            // evict the LFU node, if multiple exists, remove the LRU
            if(currSize > capacity){
                //get the LFU list
                List minFreqList = freqMap.get(minFreq);
                //remove the LRU from it, if multiple exists
                //the LRU node is the 2nd last node in the list, so remove the key
                Node LRU_Node = minFreqList.tail.prev;

                //removing the second last element from the cache hashmap
                cache.remove(LRU_Node.key);
                //now remove the node itself from the list
                minFreqList.removeFromList(LRU_Node);
                currSize--;
            }
            //as a new key has been passed, it's frequency will be 1
            //so minimum frequency will be reset to 1
            minFreq = 1;

            //creating a new node for the new key
            Node newNode = new Node(key, value); //create new node for this new key
            //we will ass it to list of frequency 1, if frequency 1 exists in freqMap
            //checking if freq with 1 is present in the hashmap or not
            List minFreqList = freqMap.getOrDefault(1, new List());
            freqMap.put(1, minFreqList); //putting the list back the freqmap
            cache.put(key,newNode); // also put it in caches
        }
    }

    public int getKey(int key){
        Node currentNode = cache.get(key);
        if(currentNode==null){ //if not present
            return -1;
        }
        //once we get the node, we will update the frequecy of that node
        updateNode(currentNode); //updating the freq of the node
        return currentNode.value;
    }
    private void updateNode(Node node){
        int currentFreq = node.freq; //getting the current freq of the node
        List currList = freqMap.get(currentFreq); //getting the double linked list
        currList.removeFromList(node); //we are removing from the current list since freq is changed

        //in case this node's frequency is minimum frequency
        //and it was the only node in the list of this frequency
        if(currentFreq == minFreq && currList.size == 0){
            minFreq++; //we will increment the frequency
        }
        node.freq++;
        // we will get the list (if exist) of this frequency
        List newList = freqMap.getOrDefault(node.freq, new List());
        newList.addToList(node); //add the node to that list
        freqMap.put(node.freq, newList); //and put the list back to the freqMap
    }

    private class Node{
        int key, value, freq; 
        //freq will keep track of number of times this node has been used
        Node next, prev;
        private Node(int key,int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    //Doubly linked list class
    private class List{
        int size;
        Node head,tail;
        //constructor
        private List(){
            this.size = 0;
            this.head = new Node(0,0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        //adding a new member to the list 
        private void addToList(Node node){
            Node headNext = head.next;
            head.next = node;
            node.next = headNext;
            headNext.prev = node;
            node.prev = head;
            size++;
        }
        private void removeFromList(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }
}

