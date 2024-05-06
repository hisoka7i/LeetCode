package LinkedList.DoublyLinkedList;

public class DNodeOperations {
    DNode node;
    //To reverse the node we only need to swap the prev and next
    //Data will remain the same
    public void reverseNode(DNode node){
        DNode temp = node;
        DNode last = null;
        while(temp!=null){
            //next 3 lines are to reverse the doubly node
            last = temp.prev;
            temp.prev = temp.next;
            temp.next = last;
            //traversing to next node
            temp = temp.prev;
        }
        //because the last element will become the new head
        //here last will be the second last element
        node = last.prev;
    }
}
